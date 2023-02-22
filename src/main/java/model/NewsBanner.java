package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@Entity
@Table(name = "news_banners")
@EqualsAndHashCode(callSuper = true)
@Data
public class NewsBanner extends MappedEntity {
    private boolean switcher;
    private int rotatingSpeed;
    @Column(length = 150)
    private String image1;
    @Column(length = 150)
    private String image2;
    @Column(length = 150)
    private String image3;
    @Column(length = 150)
    private String image4;
    @Column(length = 150)
    private String image5;
    @Column(length = 150)
    private String url1;
    @Column(length = 150)
    private String url2;
    @Column(length = 150)
    private String url3;
    @Column(length = 150)
    private String url4;
    @Column(length = 150)
    private String url5;
}