package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.DemoApplication;
import dance.withgnu.demo.user.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class S3Controller {
    private final S3Service s3Service;

    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping(path = "/s3/uploadProfile", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> uploadProfile(
            @RequestPart(value = "name") String name,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        System.out.println("teams endpoint called");
        s3Service.uploadProfile(name, file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/s3/uploadThumbnail", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> uploadThumbnail(
            @RequestPart(value = "name") String name,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        System.out.println("teams endpoint called");
        s3Service.uploadThumbnail(name, file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/s3/uploadVideo", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> uploadVideo(
            @RequestPart(value = "name") String name,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        System.out.println("teams endpoint called");
        s3Service.uploadVideo(name, file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/s3/hello")
    public ResponseEntity<Void> hello() {
        System.out.println("Hello endpoint called");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/s3/hello")
    public ResponseEntity<Void> post_hello() {
        System.out.println("Post Hello endpoint called");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

