package dance.withgnu.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/main")
    public String callFastApi() {
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
