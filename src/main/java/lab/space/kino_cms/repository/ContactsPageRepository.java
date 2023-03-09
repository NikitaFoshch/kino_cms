package lab.space.kino_cms.repository;

import lab.space.kino_cms.model.ContactsPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactsPageRepository extends JpaRepository<ContactsPage, Long> {
    Optional<ContactsPage> findFirstByOrderByIdAsc();
}
