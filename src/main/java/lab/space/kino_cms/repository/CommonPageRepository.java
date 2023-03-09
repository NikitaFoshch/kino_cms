package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.CommonPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommonPageRepository extends JpaRepository<CommonPage, Long> {
    Optional<CommonPage> findFirstByOrderByIdAsc();
}
