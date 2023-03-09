package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findFirstByOrderByIdAsc();
}
