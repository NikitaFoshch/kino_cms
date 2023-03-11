package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.CommonPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommonPageRepository extends JpaRepository<CommonPage, Long> {
    Optional<CommonPage> findFirstByOrderByIdAsc();

    @Query("from CommonPage c where c.isDefault = true order by c.id asc")
    List<CommonPage> getCommonPageByDefaultTrueByOrderByIdAsc();

    @Query("from CommonPage c where c.isDefault = false order by c.id asc")
    List<CommonPage> getCommonPageByDefaultFalseByOrderByIdAsc();

}
