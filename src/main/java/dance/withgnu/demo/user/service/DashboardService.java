package dance.withgnu.demo.user.service;

import dance.withgnu.demo.user.entity.Video;
import dance.withgnu.demo.user.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getUserVideos(String userId) {
        return videoRepository.findByUserId(Integer.parseInt(userId));
    }
}
