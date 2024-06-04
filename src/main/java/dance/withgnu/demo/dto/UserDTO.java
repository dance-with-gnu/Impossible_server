package dance.withgnu.demo.dto;

import java.util.List;
import dance.withgnu.demo.user.entity.UserEntity;

public class UserDTO {
    private Long id;
    private Long userId;
    private String userName;
    private String profileImageUrl;
    private int videoCount;
    private List<VideoListDTO> videos;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public List<VideoListDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoListDTO> videos) {
        this.videos = videos;
    }

    // UserEntity로부터 UserDTO를 생성하는 정적 팩토리 메서드
    public static UserDTO fromEntity(UserEntity userEntity, List<VideoListDTO> videos) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setProfileImageUrl(userEntity.getProfileImageUrl());
        userDTO.setVideoCount(videos.size());
        userDTO.setVideos(videos);
        return userDTO;
    }
}
