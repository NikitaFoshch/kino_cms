package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class NewsBannerBlocks extends MappedEntity {
    @Column(length = 150)
    private String image;
    @Column(length = 150)
    private String url;
    @Transient
    private MultipartFile file;
    @ManyToOne(fetch = FetchType.LAZY )
    public NewsBanner newsBanner;
}
