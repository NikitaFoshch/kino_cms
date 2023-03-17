package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.gender = 'FEMALE'")
    List<User> findAllFemaleUsers();
    @Query("from User u where u.gender = 'MALE'")
    List<User> findAllMaleUsers();
}
