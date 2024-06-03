package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.dto.DataRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "컨트롤러")
public class DataController {

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @PostMapping("/data")
    public ResponseEntity<String> postData(@RequestBody DataRequest dataRequest) {
        logger.info("Received data: " + dataRequest);
        return ResponseEntity.ok("Data received successfully");
    }
}
