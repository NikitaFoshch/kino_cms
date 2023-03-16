package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.NewsBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsBannerRepository extends JpaRepository<NewsBanner, Long> {
    Optional<NewsBanner> findFirstByOrderByIdAsc();
}
