package model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.common.MappedEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class MainPage extends MappedEntity {
    private String phone1;
    private String phone2;
    private boolean switcher;
    private String seoText;
    @OneToOne
    @JoinColumn(name = "seo_id")
    private SEO seoId;
}
