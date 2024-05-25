package dance.withgnu.demo.user.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // 사용자 정의 오류 처리를 여기서 수행합니다.
        return "error"; // error.html 템플릿을 반환합니다.
    }
}
