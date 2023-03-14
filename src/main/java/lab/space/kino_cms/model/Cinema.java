package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cinemas")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Cinema extends MappedEntity {
    private boolean isDefault;
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
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "cinema_id")
    private List<Hall> halls = List.of(new Hall());
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Seo seo = new Seo();

}
