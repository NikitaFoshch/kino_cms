package model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class News extends MappedEntity {
    private String name;
    private String description;
    private Date publicatedAt;
    private boolean disabled;
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
