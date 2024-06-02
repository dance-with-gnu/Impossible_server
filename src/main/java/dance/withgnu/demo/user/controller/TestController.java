package dance.withgnu.demo.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    private final RestTemplate restTemplate;
    private final String fastApiUrl;

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
