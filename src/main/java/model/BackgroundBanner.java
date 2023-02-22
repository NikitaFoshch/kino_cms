package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@Entity
@Table(name = "background_banners")
@EqualsAndHashCode(callSuper = true)
@Data
public class BackgroundBanner extends MappedEntity {
    private boolean backgroundImage;
    @Column(length = 150)
    private String image;
}
