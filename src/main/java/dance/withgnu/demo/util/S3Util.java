package dance.withgnu.demo.util;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class S3Util {
    @Autowired
    private AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    /**
     * 로컬 경로에 저장
     */
    public String uploadFileToS3(MultipartFile multipartFile, String filePath) {
        // MultipartFile -> File 로 변환
        File uploadFile = null;
        try {
            uploadFile = convert(multipartFile)
                    .orElseThrow(() -> new IllegalArgumentException("[error]: MultipartFile -> 파일 변환 실패"));
        } catch (IOException e) {
            log.error("파일 변환 중 오류 발생: ", e);
            throw new RuntimeException(e);
        }

        // S3에 저장된 파일 이름
        String fileName = filePath + "/" + UUID.randomUUID();

        // s3로 업로드 후 로컬 파일 삭제
        String uploadImageUrl = putS3(uploadFile, fileName);
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    /**
     * S3로 업로드
     * @param uploadFile : 업로드할 파일
     * @param fileName : 업로드할 파일 이름
     * @return 업로드 경로
     */
    public String putS3(File uploadFile, String fileName) {
        try {
            System.out.println(bucket);
            amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(
                    CannedAccessControlList.PublicRead));
            return amazonS3Client.getUrl(bucket, fileName).toString();
        } catch (AmazonServiceException e) {
            log.error("S3 업로드 중 오류 발생: ", e);
            throw new RuntimeException(e);
        }
    }


    /**
     * S3에 있는 파일 삭제
     * 영어 파일만 삭제 가능 -> 한글 이름 파일은 안됨
     */
    public void deleteS3(String filePath) throws Exception {
        try {
            String key = filePath.substring(56); // 폴더/파일.확장자
            amazonS3Client.deleteObject(bucket, key);
        } catch (AmazonServiceException e) {
            log.error("S3 파일 삭제 중 오류 발생: ", e);
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("파일 삭제 중 알 수 없는 오류 발생: ", e);
            throw new RuntimeException(e);
        }
        log.info("[S3Uploader] : S3에 있는 파일 삭제");
    }

    /**
     * 로컬에 저장된 파일 지우기
     * @param targetFile : 저장된 파일
     */
    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("[파일 업로드] : 파일 삭제 성공");
        } else {
            log.warn("[파일 업로드] : 파일 삭제 실패");
        }
    }

    /**
     * 로컬에 파일 업로드 및 변환
     * @param file : 업로드할 파일
     */
    private Optional<File> convert(MultipartFile file) throws IOException {
        String dirPath = System.getProperty("user.dir") + "/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
        File convertFile = new File(dirPath);

        if (convertFile.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }

        return Optional.empty();
    }
}
