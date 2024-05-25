package dance.withgnu.demo.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main"; // main.html 템플릿을 반환합니다.
    }

//    @GetMapping("/")
//    public String home() {
//        return "redirect:/main";
//    }
}
