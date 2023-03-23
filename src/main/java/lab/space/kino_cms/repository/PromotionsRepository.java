package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.Promotions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionsRepository extends JpaRepository<Promotions, Long> {
    List<Promotions> getPromotionsByOrderByPublicatedAtDesc();
}
