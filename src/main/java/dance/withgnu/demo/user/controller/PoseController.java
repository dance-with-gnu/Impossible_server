package dance.withgnu.demo.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "API", description = "API List")
@RequestMapping("/pose")
public class PoseController {

    @GetMapping("/list")
    @Operation(summary = "포즈 리스트", description = "포즈 리스트 path")
    public String getList() {
        return "Pose List";
    }

    // 기타 메서드 추가
}
