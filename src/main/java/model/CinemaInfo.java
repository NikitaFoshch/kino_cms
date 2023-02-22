package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@Entity
@Table(name = "cinema_infos")
@EqualsAndHashCode(callSuper = true)
@Data
public class CinemaInfo extends MappedEntity {
    @Column(length = 100)
    private String cinemaName;
    private boolean switcher;
    @Column(length = 500)
    private String address;
    @Column(length = 100)
    private String coordinates;
    @Column(length = 150)
    private String logo;
    private boolean defaultValue;
}
