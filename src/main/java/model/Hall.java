package model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@Entity
@Table(name = "halls")
@EqualsAndHashCode(callSuper = true)
@Data
public class Hall extends MappedEntity {
    @Column(length = 100)
    private String name;
    @Column(length = 1000)
    private String description;
    @Column(length = 150)
    private String schema;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;
    @OneToOne
    private SEO seo;
}
