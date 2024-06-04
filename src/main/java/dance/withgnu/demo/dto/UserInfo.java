package dance.withgnu.demo.dto;

public class UserInfo {
    private Long id;
    private int userId;
    private int userType;

    // 생성자, 게터 및 세터 메서드
    public UserInfo(Long id, int userId, int userType) {
        this.id = id;
        this.userId = userId;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
