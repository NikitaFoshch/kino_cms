package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.NewsBanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsBannerRepository extends JpaRepository<NewsBanner, Long> {
}
