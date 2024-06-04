package dance.withgnu.demo.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "API", description = "API List")
@RequestMapping("/video")
public class VideoController {

    @GetMapping("/list")
    public String getVideoList() {
        return "Video List";
    }

    // 기타 메서드 추가
}
