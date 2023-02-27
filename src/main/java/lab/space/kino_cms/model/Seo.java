package lab.space.kino_cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Seo extends MappedEntity {
    @Column(length = 150)
    private String url;
    @Column(length = 100)
    private String title;
    @Column(length = 300)
    private String keywords;
    @Column(length = 1000)
    private String description;
}
