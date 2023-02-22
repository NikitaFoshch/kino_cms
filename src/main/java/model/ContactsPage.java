package model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ContactsPage {
    @ManyToOne
    @JoinColumn(name = "cinema_info_id")
    private CinemaInfo cinemaInfoId;
    @OneToOne
    @JoinColumn(name = "seo_id")
    private SEO seoId;
}
