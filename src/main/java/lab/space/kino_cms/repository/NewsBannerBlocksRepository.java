package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.NewsBannerBlocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsBannerBlocksRepository extends JpaRepository<NewsBannerBlocks, Long> {
}
