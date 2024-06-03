package dance.withgnu.demo.user.service;

import dance.withgnu.demo.dto.LikeRequest;
import dance.withgnu.demo.user.entity.Video;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommunityService {

    public List<Video> getVideos() {
        // 비디오 리스트를 반환하는 로직
        return null;
    }

    public void likeVideo(LikeRequest likeRequest) {
        // 좋아요 로직
    }
}
