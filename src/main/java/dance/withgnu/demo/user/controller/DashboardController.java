package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.user.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/user-info")
    public ResponseEntity<UserDTO> getUserInfo(@RequestParam("user_id") Long userId) {
        UserDTO userDTO = dashboardService.getUserInfo(userId);
        return ResponseEntity.ok(userDTO);
    }
}
