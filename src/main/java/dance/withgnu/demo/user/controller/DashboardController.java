package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

<<<<<<< HEAD
    @GetMapping("/user-info")
    public ResponseEntity<UserDTO> getUserInfo(@RequestParam("user_id") Long userId) {
        UserDTO userDTO = dashboardService.getUserInfo(userId);
=======
    @GetMapping("/user_info")
    public ResponseEntity<UserDTO> getUserInfo() {
        UserDTO userDTO = dashboardService.getUserInfo(1L);
>>>>>>> 9aa3c7b33841b77efee50de970d869f3dbc89223
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/user_video")
    public List<Video> getUseVideo() {
        return dashboardService.getUserVideo(1L);
    }
}
