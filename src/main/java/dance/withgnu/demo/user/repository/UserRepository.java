package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(int userId);
    Optional<UserEntity> findByAccessToken(String accessToken);
}
