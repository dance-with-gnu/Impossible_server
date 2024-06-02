package dance.withgnu.demo.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class VideoController {

    private final RestTemplate restTemplate;
    private final String fastApiUrl;

    public VideoController(RestTemplate restTemplate, @Value("${fastapi.base-url}") String fastApiUrl) {
        this.restTemplate = restTemplate;
        this.fastApiUrl = fastApiUrl;
    }

    @PostMapping("/upload-video")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        String url = fastApiUrl + "/upload/";

        // Create a multi-part form data request
        org.springframework.http.HttpEntity<org.springframework.util.MultiValueMap<String, Object>> requestEntity =
                new org.springframework.http.HttpEntity<>(createMultipartRequest(file));

        // Send the request to the FastAPI server
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

        return response;
    }

    private org.springframework.util.MultiValueMap<String, Object> createMultipartRequest(MultipartFile file) throws IOException {
        org.springframework.util.LinkedMultiValueMap<String, Object> map = new org.springframework.util.LinkedMultiValueMap<>();
        map.add("file", new org.springframework.core.io.ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        });
        return map;
    }
}
