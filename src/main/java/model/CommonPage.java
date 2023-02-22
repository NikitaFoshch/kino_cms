package model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonPage extends MappedEntity {
    private String name;
    private String description;
    private boolean switcher;
    private String mainImage;
    private String galleryImage1;
    private String galleryImage2;
    private String galleryImage3;
    private String galleryImage4;
    private String galleryImage5;
    @OneToOne
    @JoinColumn(name = "seo_id")
    private SEO seoId;
}
