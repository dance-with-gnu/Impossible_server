package dance.withgnu.demo.user.service;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.dto.VideoListDTO;
import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.repository.UserRepository;
import dance.withgnu.demo.user.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    public UserDTO getUserInfoById(Long userId) {
        UserDTO userDTO = userRepository.getUserInfo(userId);

        List<Video> videos = videoRepository.findByUserId(userId);
        List<VideoListDTO> videoListDTOs = videos.stream()
                .map(video -> new VideoListDTO(
                        video.getId(),
                        video.getUserId(),
                        "UserName",  // 대체할 실제 사용자 이름
                        "MusicName", // 대체할 실제 음악 이름
                        0,           // 대체할 실제 pose number
                        0,           // 대체할 실제 heart 수
                        0,           // 대체할 실제 view 수
                        video.getUserId(),
                        video.getPoseCategoryId(),
                        video.getVideoUrl(),
                        video.getCreateDate()
                ))
                .collect(Collectors.toList());

        userDTO.setVideos(videoListDTOs);
        return userDTO;
    }
}
