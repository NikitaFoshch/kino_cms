package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    List<Hall> getHallsByCinemaOrderByCreateAt(Cinema cinema);
}
