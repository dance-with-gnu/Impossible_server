package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
