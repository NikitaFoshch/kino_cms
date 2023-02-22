package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@Entity
@Table
@EqualsAndHashCode(callSuper = true)
@Data
public class SEO extends MappedEntity {
    @Column(length = 150)
    private String url;
    @Column(length = 100)
    private String title;
    @Column(length = 300)
    private String keywords;
    @Column(length = 1000)
    private String description;
}
