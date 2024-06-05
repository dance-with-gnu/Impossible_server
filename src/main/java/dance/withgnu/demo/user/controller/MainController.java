package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.user.service.S3Service;
import dance.withgnu.demo.user.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class MainController {

    private final VideoService videoService;

    @Value("${ai.server.host}")
    private String aiHost;

    @Value("${ai.server.port}")
    private String aiPort;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private S3Service s3Service;

    public MainController(VideoService videoService) {
        this.videoService = videoService;
    }

    private String getAIUrl(String path) {
        return "http://" + aiHost + ":" + aiPort + "/" + path;
    }

    @GetMapping("/main")
    public String callFastApi() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(getAIUrl("home"), String.class);
            String apiResponse = response.getBody();
            System.out.println("FastAPI Response: " + apiResponse);
            return "FastAPI Response: " + apiResponse;
        } catch (Exception e) {
            System.out.println("Error calling FastAPI: " + e.getMessage());
            return "Error calling FastAPI: " + e.getMessage();
        }
    }

    @PostMapping("/video/upload/example")
    @Operation(summary = "Upload video", description = "Upload video and save to S3")
    public ResponseEntity<String> makeVideoFastApi(
            @RequestParam("file") MultipartFile file
    ) {

        // Upload to S3
//                    String s3Url = videoService.createAndSaveVideo(userId, multipartFile, danceNumber, stepSize, fps, length);
        String s3Url = s3Service.uploadVideo("hello", file);
        return ResponseEntity.ok("Video received and uploaded to S3: " + s3Url);
    }
    @PostMapping("/video/upload")
    @Operation(summary = "Upload video", description = "Upload video and save to S3")
    public ResponseEntity<String> makeVideoFastApi(
            @RequestParam("user_id") int userId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("dance_number") int danceNumber,
            @RequestParam("step_size") int stepSize,
            @RequestParam(value = "fps", required = false) int fps,
            @RequestParam(value = "length", required = false) Integer length
    ) {
        try {
            // Create headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // Create body
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            ByteArrayResource byteArrayResource = new ByteArrayResource(file.getBytes()) {
                @Override
                public String getFilename() {
                    return file.getOriginalFilename();
                }
            };
            body.add("file", byteArrayResource);
            body.add("dance_number", danceNumber);
            body.add("step_size", stepSize);
            body.add("fps", fps);
            if (length != null) {
                body.add("length", length);
            }

            // Create HttpEntity
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // Send request to FastAPI server
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    getAIUrl("upload/"),
                    HttpMethod.POST,
                    requestEntity,
                    byte[].class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                byte[] videoBytes = response.getBody();
                if (videoBytes != null) {
                    // Save the video file to a temporary location
                    File tempFile = File.createTempFile("received_video", ".mp4");
                    try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                        fos.write(videoBytes);
                    }

                    // Convert the temporary file to MultipartFile
                    DiskFileItem fileItem = new DiskFileItem("file", Files.probeContentType(tempFile.toPath()), false, tempFile.getName(), (int) tempFile.length(), tempFile.getParentFile());
                    fileItem.getOutputStream().write(Files.readAllBytes(tempFile.toPath()));
                    MultipartFile multipartFile = new MockMultipartFile(
                            tempFile.getName(), tempFile.getName(), "video/mp4", Files.readAllBytes(tempFile.toPath()));


                    // Upload to S3
                    String s3Url = videoService.createAndSaveVideo(userId, multipartFile, danceNumber, stepSize, fps, length);


                    // Optionally, delete the temporary file
                    tempFile.delete();


                    return ResponseEntity.ok("Video received and uploaded to S3: " + s3Url);
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: No video received.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + response.getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
