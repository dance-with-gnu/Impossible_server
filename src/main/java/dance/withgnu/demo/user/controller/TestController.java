package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.dto.UserDTO;
import dance.withgnu.demo.user.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    private final RestTemplate restTemplate;
    private final String fastApiUrl;
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/test/user-info")
    public UserDTO getUserInfo(@RequestParam Long userId) {
        return dashboardService.getUserInfo(userId);
    }

    public TestController(RestTemplate restTemplate, @Value("${fastapi.base-url}") String fastApiUrl) {
        this.restTemplate = restTemplate;
        this.fastApiUrl = fastApiUrl;
    }

    @GetMapping("/test-api")
    public ResponseEntity<String> testApi() {
        String url = fastApiUrl + "/home"; // 실제 엔드포인트로 변경
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
