package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(Long userId);

    UserEntity findByAccessToken(String accessToken);

    @Query("SELECT new dance.withgnu.demo.dto.UserDTO(u.id, u.userId, u.userName, u.profileImageUrl, COUNT(v)) " +
            "FROM UserEntity u LEFT JOIN Video v ON u.userId = v.userId " +
            "WHERE u.userId = :userId GROUP BY u.userId")
    UserDTO getUserInfo(@Param("userId") Long userId);

}


