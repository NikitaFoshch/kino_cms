package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
