package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@Entity
@Table(name = "cinemas")
@EqualsAndHashCode(callSuper = true)
@Data
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
