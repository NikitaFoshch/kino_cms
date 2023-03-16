package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.TopBannerBlocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopBannerBlocksRepository extends JpaRepository<TopBannerBlocks,Long> {
}
