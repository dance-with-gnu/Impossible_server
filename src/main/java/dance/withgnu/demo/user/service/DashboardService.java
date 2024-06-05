package dance.withgnu.demo.user.service;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.dto.VideoListDTO;
import dance.withgnu.demo.user.entity.UserEntity;
import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.repository.UserRepository;
import dance.withgnu.demo.user.repository.VideoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final VideoRepository videoRepository;

    @Autowired
<<<<<<< HEAD
    public DashboardService(UserRepository userRepository, VideoRepository videoRepository) {
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
    }

    @Transactional
=======
    private VideoRepository videoRepository;
    public List<Video> getUserVideo(Long userId) {
        return videoRepository.findByUserId(userId);
    }
>>>>>>> 9aa3c7b33841b77efee50de970d869f3dbc89223
    public UserDTO getUserInfo(Long userId) {
        UserEntity user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        List<VideoListDTO> videos = videoRepository.findByUserId(userId)
                .stream()
                .map(video -> new VideoListDTO(
                        video.getId(),
                        video.getUserId(),
                        video.getUserName(),
                        video.getMusicName(),
                        video.getPoseNumber(),
                        video.getHeart(),
                        video.getView(),
                        video.getUserId(),
                        video.getPoseCategoryId(),
                        video.getVideoUrl(),
                        video.getCreateDate()))
                .collect(Collectors.toList());

        return UserDTO.fromEntity(user, videos);
    }
}