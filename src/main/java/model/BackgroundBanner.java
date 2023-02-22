package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class BackgroundBanner extends MappedEntity {
    private boolean backgroundImage;
    private String image;
}
