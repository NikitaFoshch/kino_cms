package model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cinema extends MappedEntity {
    private String name;
    private String description;
    private String conditions;
    private String logo;
    private String topBanner;
    private String galleryImage1;
    private String galleryImage2;
    private String galleryImage3;
    private String galleryImage4;
    private String galleryImage5;
    @OneToOne
    @JoinColumn(name = "seo_id")
    private SEO seoId;
}
