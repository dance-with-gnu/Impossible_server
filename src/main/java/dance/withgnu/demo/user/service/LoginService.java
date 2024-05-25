package dance.withgnu.demo.user.service;

import dance.withgnu.demo.user.entity.UserEntity;
import dance.withgnu.demo.user.entity.KakaoUserEntity;
import dance.withgnu.demo.user.entity.AppleUserEntity;
import dance.withgnu.demo.user.repository.UserRepository;
import dance.withgnu.demo.user.repository.KakaoUserRepository;
import dance.withgnu.demo.user.repository.AppleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KakaoUserRepository kakaoUserRepository;

    @Autowired
    private AppleUserRepository appleUserRepository;

    public UserEntity loginWithKakao(String kakaoId) {
        KakaoUserEntity kakaoUserEntity = kakaoUserRepository.findByKakaoId(kakaoId);
        if (kakaoUserEntity != null) {
            return userRepository.findByUserId(kakaoUserEntity.getUserId());
        }
        return null;
    }

    public UserEntity loginWithApple(String appleId) {
        AppleUserEntity appleUserEntity = appleUserRepository.findByAppleId(appleId);
        if (appleUserEntity != null) {
            return userRepository.findByUserId(appleUserEntity.getUserId());
        }
        return null;
    }
}
