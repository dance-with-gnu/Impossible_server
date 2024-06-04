package dance.withgnu.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class MainController {
    @Value("${ai.server.host}")
    private String aiHost;

    @Value("${ai.server.port}")
    private String aiPort;

    private String getAIUrl(String path) {
        return "http://"+aiHost+":"+aiPort+"/"+path;
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/main")
    public String callFastApi() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(getAIUrl("home"), String.class);
            String apiResponse = response.getBody();
            System.out.println("FastAPI Response: " + apiResponse);
            return "FastAPI Response: " + apiResponse;
        } catch (Exception e) {
            System.out.println("Error calling FastAPI: " + e.getMessage());
            return "Error calling FastAPI: " + e.getMessage();
        }
    }

    @PostMapping("/upload")
    public String makeVideoFastApi() {
        String fastApiUrl = "http://163.239.27.110:8890/home"; // FastAPI 엔드포인트
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(fastApiUrl, String.class);
            String apiResponse = response.getBody();
            System.out.println("FastAPI Response: " + apiResponse);
            return "FastAPI Response: " + apiResponse;
        } catch (Exception e) {
            System.out.println("Error calling FastAPI: " + e.getMessage());
            return "Error calling FastAPI: " + e.getMessage();
        }
    }
}
