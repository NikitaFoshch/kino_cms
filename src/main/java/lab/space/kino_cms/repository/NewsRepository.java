package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> getNewsByOrderByPublicatedAtDesc();
}
