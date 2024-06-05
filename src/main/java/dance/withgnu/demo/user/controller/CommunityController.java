package dance.withgnu.demo.user.controller;

import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.service.VideoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "API", description = "API List")
@RequestMapping("/community")
public class CommunityController {

    private final VideoService videoService;

    @Autowired
    public CommunityController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/test")
    public String test() {
        return "Community Test";
    }

    @GetMapping("/videolist")
    public List<Video> getVideoList() {
        Long excludeUserId = 1L;
        return videoService.getVideosExcludingUser(excludeUserId);
    }
}
