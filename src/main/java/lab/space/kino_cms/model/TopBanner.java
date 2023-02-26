package lab.space.kino_cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "top_banners")
@Data
@EqualsAndHashCode(callSuper = true)
public class TopBanner extends MappedEntity {
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
    @Column(length = 150)
    private String text1;
    @Column(length = 150)
    private String text2;
    @Column(length = 150)
    private String text3;
    @Column(length = 150)
    private String text4;
    @Column(length = 150)
    private String text5;
}
