package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByUserId(Long userId);
    List<Video> findByUserIdNot(Long userId);
}
