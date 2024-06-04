package dance.withgnu.demo.user.service;

import dance.withgnu.demo.dto.VideoListDTO;
import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
    public String uploadMedia(MultipartFile file, Long videoId) {
        try {
            // 파일 저장 경로 설정
            Path path = Paths.get("uploads/" + file.getOriginalFilename());

            // 파일 저장
            Files.write(path, file.getBytes());

            // 비디오 메타데이터 저장 로직 (예: videoId와 함께 데이터베이스에 저장)

            return "File uploaded successfully";
        } catch (IOException e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }
    public List<VideoListDTO> getAllVideos() {
        List<Video> videos = videoRepository.findAll();
        return videos.stream().map(video -> {
            VideoListDTO dto = new VideoListDTO();
            dto.setUserId(video.getUserId());
            dto.setVideoId(video.getVideoId());
            dto.setUserName("UserName"); // 예시 사용자 이름,
            dto.setMusicName("MusicName"); // 예시 음악 이름
            dto.setPoseNumber(0); // 예시 PoseNumber
            dto.setHeart(0); // 예시 Heart
            dto.setView(0); // 예시 View
            dto.setPoseId(0); // 예시 PoseId
            dto.setPoseCategoryId(0); // 예시 PoseCategoryId
            dto.setVideoUrl(video.getVideoLink());
            dto.setCreateDate(video.getCreateDate());
            return dto;
        }).collect(Collectors.toList());
    }
}
