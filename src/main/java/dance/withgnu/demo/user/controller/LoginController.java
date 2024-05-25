package dance.withgnu.demo.user.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal OAuth2User oAuth2User) {
        // 로그인 성공 시 처리
        if (oAuth2User != null) {
            System.out.println("User attributes: " + oAuth2User.getAttributes());
        }
        return "redirect:/main";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        // 로그인 실패 시 처리
        return "redirect:/login";
    }
}
