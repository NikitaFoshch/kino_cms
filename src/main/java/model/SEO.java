package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class SEO extends MappedEntity {
    private String url;
    private String title;
    private String keywords;
    private String description;
}
