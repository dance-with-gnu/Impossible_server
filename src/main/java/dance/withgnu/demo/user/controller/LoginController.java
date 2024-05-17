package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.user.service.LoginService;
import dance.withgnu.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login/kakao")
    public User loginWithKakao(@RequestParam String kakaoId) {
        return loginService.loginWithKakao(kakaoId);
    }

    @GetMapping("/login/apple")
    public User loginWithApple(@RequestParam String appleId) {
        return loginService.loginWithApple(appleId);
    }
}
