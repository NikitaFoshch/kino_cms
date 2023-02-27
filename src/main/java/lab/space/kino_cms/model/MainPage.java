package lab.space.kino_cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "main_pages")
@Data
@EqualsAndHashCode(callSuper = true)
public class MainPage extends MappedEntity {
    @Column(length = 20)
    private String phone1;
    @Column(length = 20)
    private String phone2;
    private boolean switcher;
    @Column(length = 1000)
    private String seoText;
    @OneToOne
    private Seo seo;
}
