package lab.space.kino_cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cinema_infos")
@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaInfo extends MappedEntity {
    @Column(length = 100)
    private String cinemaName;
    private boolean switcher;
    @Column(length = 500)
    private String address;
    @Column(length = 100)
    private String coordinates;
    @Column(length = 150)
    private String logo;
    private boolean isDefault;

    @ManyToOne
    private ContactsPage contactsPage;
}
