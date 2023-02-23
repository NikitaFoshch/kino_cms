package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.SEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SEORepository extends JpaRepository<SEO, Long> {
}
