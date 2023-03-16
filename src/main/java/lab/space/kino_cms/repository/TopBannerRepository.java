package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.TopBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopBannerRepository extends JpaRepository<TopBanner, Long> {
    Optional<TopBanner> findFirstByOrderByIdAsc();
}
