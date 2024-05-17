package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.AppleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppleUserRepository extends JpaRepository<AppleUser, Long> {
    AppleUser findByAppleId(String appleId); // 메서드 추가
}
