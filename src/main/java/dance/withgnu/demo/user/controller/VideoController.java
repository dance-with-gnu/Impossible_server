package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.user.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class VideoController {

//    @Autowired
//    private VideoService videoService;
//
//    @PostMapping(path = "/video/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public ResponseEntity<String> uploadVideo(
//            @RequestPart("image") MultipartFile image,
//            @RequestParam("videoId") Long videoId
//    ) {
//        String result = videoService.createAndSaveVideo(image, videoId);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}
