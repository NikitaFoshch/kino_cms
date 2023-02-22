package model;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class Hall extends MappedEntity {
    private String name;
    private String description;
    private String schema;
    private String topBanner;
    private String galleryImage1;
    private String galleryImage2;
    private String galleryImage3;
    private String galleryImage4;
    private String galleryImage5;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaId;
    @OneToOne
    @JoinColumn(name = "seo_id")
    private SEO seoId;
}
