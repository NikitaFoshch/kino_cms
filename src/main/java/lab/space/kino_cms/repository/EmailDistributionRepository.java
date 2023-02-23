package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.EmailDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDistributionRepository extends JpaRepository<EmailDistribution, Long> {
}
