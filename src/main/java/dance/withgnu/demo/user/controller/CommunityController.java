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

    // 기타 메서드 추가
}
//@RestController
//public class CommunityController {
//
//    @GetMapping("/community/videos")
//    public List<Video> getVideos() {
//        // 비디오 리스트 반환 로직
//        return null;
//    }
//
////    @PostMapping("/community/like")
////    public void likeVideo(@RequestBody LikeRequest likeRequest) {
////        // 좋아요 로직
////    }
//}
