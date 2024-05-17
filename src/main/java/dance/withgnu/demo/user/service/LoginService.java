package dance.withgnu.demo.user.service;

import dance.withgnu.demo.user.entity.AppleUser;
import dance.withgnu.demo.user.entity.KakaoUser;
import dance.withgnu.demo.user.entity.User;
import dance.withgnu.demo.user.repository.AppleUserRepository;
import dance.withgnu.demo.user.repository.KakaoUserRepository;
import dance.withgnu.demo.user.repository.UserRepository;
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

    public User loginWithKakao(String kakaoId) {
        KakaoUser kakaoUser = kakaoUserRepository.findByKakaoId(kakaoId);
        if (kakaoUser != null) {
            return userRepository.findByUserId(kakaoUser.getUserId());
        }
        return null;
    }

    public User loginWithApple(String appleId) {
        AppleUser appleUser = appleUserRepository.findByAppleId(appleId);
        if (appleUser != null) {
            return userRepository.findByUserId(appleUser.getUserId());
        }
        return null;
    }
}
