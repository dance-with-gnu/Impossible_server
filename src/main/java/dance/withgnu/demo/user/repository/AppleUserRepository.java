package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.AppleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppleUserRepository extends JpaRepository<AppleUserEntity, Long> {
    AppleUserEntity findByAppleId(String appleId); // 메서드 추가
}
