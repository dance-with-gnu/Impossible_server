package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.service.DashboardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "API", description = "API List")
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/user_info")
    public ResponseEntity<UserDTO> getUserInfo() {
        UserDTO userDTO = dashboardService.getUserInfo(1L);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/user_video")
    public List<Video> getUseVideo() {
        return dashboardService.getUserVideo(1L);
    }
}
