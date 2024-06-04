package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.user.entity.Pose;
import dance.withgnu.demo.user.service.PoseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Pose> getList() {
        return poseService.getAllPoses();
    }
}
