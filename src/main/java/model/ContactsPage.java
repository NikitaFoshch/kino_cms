package model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "contacts_pages")
@Data
public class ContactsPage {
    @Id
    @ManyToOne
    private CinemaInfo cinemaInfo;
    @OneToOne
    private SEO seo;
}
