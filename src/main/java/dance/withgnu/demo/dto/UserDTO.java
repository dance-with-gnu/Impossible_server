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

    // 파라미터가 있는 생성자
    public UserDTO(Long id, Long userId, String userName, String profileImageUrl, long videoCount) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.profileImageUrl = profileImageUrl;
        this.videoCount = (int) videoCount;
    }

    // UserEntity로부터 UserDTO를 생성하는 정적 팩토리 메서드
    public static UserDTO fromEntity(UserEntity userEntity, List<VideoListDTO> videos) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getUserId(),
                userEntity.getUserName(),
                userEntity.getProfileImageUrl(),
                videos.size()
        );
    }
}
