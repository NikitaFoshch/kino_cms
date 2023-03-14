package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findFirstByOrderByIdAsc();
    @Query("from Movie m order by m.id asc limit 8")
    List<Movie> getEightMovieByOrderById();
    @Query("from Movie m order by m.id desc limit 4")
    List<Movie> getFourMovieByOrderById();
}
