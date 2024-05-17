package dance.withgnu.demo.user.repository;

import dance.withgnu.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(int userId);
}
