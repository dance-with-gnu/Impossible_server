package dance.withgnu.demo.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "loginSelection"; // loginSelection.html 템플릿을 반환합니다.
    }
}
