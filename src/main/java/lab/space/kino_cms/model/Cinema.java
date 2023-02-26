package lab.space.kino_cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cinemas")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cinema extends MappedEntity {
    @Column(length = 100)
    private String name;
    @Column(length = 1000)
    private String description;
    @Column(length = 1000)
    private String conditions;
    @Column(length = 150)
    private String logo;
    @Column(length = 150)
    private String topBanner;
    @Column(length = 150)
    private String galleryImage1;
    @Column(length = 150)
    private String galleryImage2;
    @Column(length = 150)
    private String galleryImage3;
    @Column(length = 150)
    private String galleryImage4;
    @Column(length = 150)
    private String galleryImage5;
    @OneToOne
    private SEO seo;
}
