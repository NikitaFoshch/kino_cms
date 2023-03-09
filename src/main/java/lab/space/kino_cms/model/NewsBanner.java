package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "news_banners")
@Data
@EqualsAndHashCode(callSuper = true)
public class NewsBanner extends MappedEntity {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "news_banner_id")
    private List<NewsBannerBlocks> newsBannerBlocks;
    private boolean disabled;
    private int rotatingSpeed;
}
