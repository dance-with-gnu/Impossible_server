package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.Pose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoseRepository extends JpaRepository<Pose, Long> {
}
