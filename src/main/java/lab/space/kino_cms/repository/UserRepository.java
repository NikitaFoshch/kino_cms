package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
