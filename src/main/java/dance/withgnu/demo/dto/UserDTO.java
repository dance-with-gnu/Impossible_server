package dance.withgnu.demo.dto;

import dance.withgnu.demo.user.entity.UserEntity;

public class UserDTO {
    private Long id;
    private int userId;
    private int userType;

    // 생성자
    public UserDTO(Long id, int userId, int userType) {
        this.id = id;
        this.userId = userId;
        this.userType = userType;
    }

    // UserEntity로부터 UserDTO를 생성하는 정적 팩토리 메서드
    public static UserDTO fromEntity(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getUserId(), userEntity.getUserType());
    }

    // Getters and Setters
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
