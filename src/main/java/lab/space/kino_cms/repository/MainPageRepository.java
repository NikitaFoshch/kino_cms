package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.MainPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainPageRepository extends JpaRepository<MainPage, Long> {
}
