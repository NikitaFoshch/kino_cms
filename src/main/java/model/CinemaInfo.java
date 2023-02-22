package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaInfo extends MappedEntity {
    private String cinemaName;
    private boolean switcher;
    private String address;
    private String coordinates;
    private String logo;
    private boolean defaultValue;
}
