package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.user.entity.Pose;
import dance.withgnu.demo.user.service.PoseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import dance.withgnu.demo.user.entity.Pose;

@RestController
@Tag(name = "API", description = "API List")
@RequestMapping("/pose")
public class PoseController {

    private final PoseService poseService;

    @Autowired
    public PoseController(PoseService poseService) {
        this.poseService = poseService;
    }

    @GetMapping("/list")
    @Operation(summary = "포즈 리스트", description = "포즈 리스트 path")
    public Pose getList(@RequestParam String x) {
        // x 값을 사용하여 Pose 객체를 생성하고 반환합니다.
        Pose pose = new Pose();
        pose.setId(Long.parseLong(x));
        return pose;
    }

    @GetMapping("/like")
    @Operation(summary = "좋아요", description = "좋아요 갯수")
    public String getLike() { return "좋아요 갯수";} // 이건 일단 boolean 으로?
    // 기타 메서드 추가
}
