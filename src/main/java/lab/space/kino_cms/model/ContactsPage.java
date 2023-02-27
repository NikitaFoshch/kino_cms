package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "contacts_pages")
@Data
public class ContactsPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<CinemaInfo> cinemaInfo;
    @OneToOne
    private Seo seo;
}
