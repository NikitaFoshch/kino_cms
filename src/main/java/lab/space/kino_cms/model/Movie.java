package lab.space.kino_cms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Movie extends MappedEntity {
    private boolean disabled;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD.MM.YYYY")
    private LocalDate release;
    @Column(length = 100)
    private String name;
    @Column(length = 1000)
    private String description;
    private boolean type3D;
    private boolean type2D;
    private boolean imax;
    private boolean dbox;
    private boolean plus18;
    private boolean plus16;
    private boolean plus12;
    @Column(length = 150)
    private String trailerUrl;
    @Column(length = 150)
    private String mainImage;
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
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Seo seo = new Seo();
}
