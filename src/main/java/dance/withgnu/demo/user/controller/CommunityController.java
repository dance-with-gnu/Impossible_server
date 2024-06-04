package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.dto.LikeRequest;
import dance.withgnu.demo.user.entity.Video;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "API", description = "API List")
@RequestMapping("/community")
public class CommunityController {

    @GetMapping("/test")
    public String test() {
        return "Community Test";
    }

    @GetMapping("/videolist")
    public String VideoList() { return "VideoList";}

}

