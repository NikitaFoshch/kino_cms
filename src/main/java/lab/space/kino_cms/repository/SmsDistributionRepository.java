package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.SmsDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsDistributionRepository extends JpaRepository<SmsDistribution, Long> {
}
