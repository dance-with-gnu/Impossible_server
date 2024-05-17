package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.KakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoUserRepository extends JpaRepository<KakaoUser, Long> {
    KakaoUser findByKakaoId(String kakaoId);
}
