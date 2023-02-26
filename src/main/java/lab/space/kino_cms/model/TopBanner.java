package lab.space.kino_cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "top_banners")
@Data
@EqualsAndHashCode(callSuper = true)
public class TopBanner extends MappedEntity {
    private boolean switcher;
    private int rotatingSpeed;
}
