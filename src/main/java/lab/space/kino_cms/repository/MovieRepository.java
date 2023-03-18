package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findFirstByOrderByIdAsc();
}
