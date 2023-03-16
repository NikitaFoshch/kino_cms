package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "news_banners")
@Data
@EqualsAndHashCode(callSuper = true)
public class NewsBanner extends MappedEntity {
    private boolean disabled;
    private int rotatingSpeed;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "news_banner_id")
    private List<NewsBannerBlocks> newsBannerBlocksList = new ArrayList<>();
}
