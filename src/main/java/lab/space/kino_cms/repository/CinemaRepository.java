package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
    Optional<Cinema> findFirstByOrderByIdAsc();
}
