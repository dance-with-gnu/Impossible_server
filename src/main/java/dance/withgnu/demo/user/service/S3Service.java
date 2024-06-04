package dance.withgnu.demo.user.service;
import dance.withgnu.demo.DemoApplication;
import dance.withgnu.demo.user.service.S3Service;
import dance.withgnu.demo.util.S3Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class S3Service {
    private final S3Util s3Util;

    @Autowired
    public S3Service(S3Util s3Util) {
        this.s3Util = s3Util;
    }

    @Transactional
    public String uploadThumbnail(String name, MultipartFile file) {
        String url = "";
        if (file != null) url = s3Util.uploadFileToS3(file, "thumbnails");
        return url;
    }

    @Transactional
    public String uploadVideo(String name, MultipartFile file) {
        String url = "";
        if (file != null) url = s3Util.uploadFileToS3(file, "videos");
        return url;
    }

    @Transactional
    public String uploadProfile(String name, MultipartFile file) {
        String url = "";
        if (file != null) url = s3Util.uploadFileToS3(file, "profile");
        return url;
    }
}