package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.CinemaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaInfoRepository extends JpaRepository<CinemaInfo, Long> {
}
