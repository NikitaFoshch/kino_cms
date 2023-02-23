package lab.space.kino_cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "background_banners")
@EqualsAndHashCode(callSuper = true)
@Data
public class BackgroundBanner extends MappedEntity {
    private boolean backgroundImage;
    @Column(length = 150)
    private String image;
}
