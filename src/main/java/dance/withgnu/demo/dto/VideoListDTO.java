package dance.withgnu.demo.dto;

import java.time.LocalDateTime;

public class VideoListDTO {

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getPoseNumber() {
        return poseNumber;
    }

    public void setPoseNumber(int poseNumber) {
        this.poseNumber = poseNumber;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getPoseId() {
        return poseId;
    }

    public void setPoseId(int poseId) {
        this.poseId = poseId;
    }

    public int getPoseCategoryId() {
        return poseCategoryId;
    }

    public void setPoseCategoryId(int poseCategoryId) {
        this.poseCategoryId = poseCategoryId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    private Long userId;
    private Long videoId;
    private String userName;
    private String musicName;
    private int poseNumber;
    private int heart;
    private int view;
    private int poseId;
    private int poseCategoryId;
    private String videoUrl;
    private LocalDateTime createDate;

    // Getters and Setters
}
