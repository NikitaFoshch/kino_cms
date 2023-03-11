package lab.space.kino_cms.model;

import jakarta.persistence.*;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "main_pages")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MainPage extends MappedEntity {
    private final String title = "Главная страница";
    @Column(length = 20)
    private String phone1;
    @Column(length = 20)
    private String phone2;
    private boolean disabled;
    @Column(length = 1000)
    private String seoText;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Seo seo = new Seo();
}
