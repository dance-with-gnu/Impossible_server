package dance.withgnu.demo.user.service;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.dto.VideoListDTO;
import dance.withgnu.demo.user.entity.UserEntity;
import dance.withgnu.demo.user.repository.UserRepository;
import dance.withgnu.demo.user.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    public UserDTO getUserInfo(Long userId) {
        UserEntity user = userRepository.findByUserId(userId);
        List<VideoListDTO> videoDTOs = videoRepository.findByUserId(userId)
                .stream()
                .map(video -> new VideoListDTO(
                        video.getId(),
                        user.getId(),
                        user.getUserName(),
                        video.getMusicName(),
                        video.getPoseNumber(),
                        video.getHeart(),
                        video.getView(),
                        video.getUserId(),
                        video.getPoseCategoryId(),
                        video.getVideoUrl(),
                        video.getCreateDate()
                ))
                .collect(Collectors.toList());
        return UserDTO.fromEntity(user, videoDTOs);
    }
}
