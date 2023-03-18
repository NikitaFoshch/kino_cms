package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "halls")
@Data
@EqualsAndHashCode(callSuper = true)
public class Hall extends MappedEntity {
    private boolean isDefault;
    private boolean disabled;
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
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Seo seo = new Seo();

    public Hall(){}
    public Hall(String name, boolean isDefault){
        this.name = name;
        this.isDefault = isDefault;
    }

}
