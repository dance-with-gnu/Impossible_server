package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.KakaoUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoUserRepository extends JpaRepository<KakaoUserEntity, Long> {
    KakaoUserEntity findByKakaoId(String kakaoId);
}
