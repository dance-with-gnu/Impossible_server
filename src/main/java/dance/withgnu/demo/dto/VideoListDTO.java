package dance.withgnu.demo.dto;

import java.time.LocalDateTime;

public class VideoListDTO {

    private Long videoId;
    private Long userId;
    private String userName;
    private String musicName;
    private int poseNumber;
    private int heart;
    private int view;
    private Long poseId;
    private int poseCategoryId;
    private String videoUrl;
    private LocalDateTime createDate;

    // 필요한 생성자
    public VideoListDTO(Long videoId, Long userId, String userName, String musicName, int poseNumber, int heart, int view, Long poseId, int poseCategoryId, String videoUrl, LocalDateTime createDate) {
        this.videoId = videoId;
        this.userId = userId;
        this.userName = userName;
        this.musicName = musicName;
        this.poseNumber = poseNumber;
        this.heart = heart;
        this.view = view;
        this.poseId = poseId;
        this.poseCategoryId = poseCategoryId;
        this.videoUrl = videoUrl;
        this.createDate = createDate;
    }

    public VideoListDTO() {

    }

    // Getters and Setters

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
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

    public Long getPoseId() {
        return poseId;
    }

    public void setPoseId(Long poseId) {
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
}
