package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.SMSDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSDistributionRepository extends JpaRepository<SMSDistribution, Long> {
}
