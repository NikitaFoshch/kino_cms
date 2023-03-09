package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.BackgroundBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackgroundBannerRepository extends JpaRepository<BackgroundBanner, Long> {
    Optional<BackgroundBanner> findFirstByOrderByIdAsc();
}
