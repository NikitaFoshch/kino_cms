package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.CinemaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaInfoRepository extends JpaRepository<CinemaInfo, Long> {
    Optional<CinemaInfo> findFirstByOrderByIdAsc();

    @Query("from CinemaInfo c order by c.isDefault desc")
    List<CinemaInfo> getAllCinemaInfosByOrderByDefaultDesc();
}
