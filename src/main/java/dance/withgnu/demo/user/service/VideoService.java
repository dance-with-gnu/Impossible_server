package dance.withgnu.demo.user.service;

import dance.withgnu.demo.user.entity.Pose;
import dance.withgnu.demo.user.entity.UserEntity;
import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.repository.PoseRepository;
import dance.withgnu.demo.user.repository.UserRepository;
import dance.withgnu.demo.user.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

import static dance.withgnu.demo.user.entity.Video.*;

@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;
    private final PoseRepository poseRepository;
    private final S3Service s3Service;

    @Autowired
    public VideoService(VideoRepository videoRepository, UserRepository userRepository, PoseRepository poseRepository, S3Service s3Service) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
        this.poseRepository = poseRepository;
        this.s3Service = s3Service;
    }

    @Transactional
    public String createAndSaveVideo(int userId, MultipartFile file, int danceNumber, int stepSize, int fps, Integer length) {
        System.out.println("시작은?");
        UserEntity user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Pose pose = poseRepository.findByPoseId(danceNumber);
        if (pose == null) {
            throw new RuntimeException("Pose not found");
        }
        System.out.println("여기는?");

        String s3Url = s3Service.uploadVideo(user.getUserName(), file);
        System.out.println("여기는 왔나?");
        Video video = Video.builder()
                .userId((long) userId)
                .userName(user.getUserName())
                .musicName(pose.getName())
                .poseNumber(pose.getPoseId())
                .heart(0)
                .view(0)
                .poseNumber((int) pose.getPoseId())
                .poseCategoryId(pose.getPoseCategoryId())
                .videoUrl(s3Url)
                .createDate(LocalDateTime.now())
                .build();

        videoRepository.save(video);

        return s3Url;
    }
}
