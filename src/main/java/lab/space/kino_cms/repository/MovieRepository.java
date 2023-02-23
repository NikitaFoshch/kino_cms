package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
