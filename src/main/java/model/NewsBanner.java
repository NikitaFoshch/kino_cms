package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class NewsBanner extends MappedEntity {
    private boolean switcher;
    private int rotatingSpeed;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;
}