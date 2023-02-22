package model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class Movie extends MappedEntity {
    private String name;
    private String description;
    private boolean type3D;
    private boolean type2D;
    private boolean imax;
    private String trailerUrl;
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
