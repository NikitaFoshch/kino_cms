package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contacts_pages")
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactsPage extends MappedEntity {
    private final String title = "Контакты";
    private boolean disabled = true;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contacts_page_id")
    private List<CinemaInfo> cinemaInfoList = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Seo seo = new Seo();
}
