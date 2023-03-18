package lab.space.kino_cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lab.space.kino_cms.model.common.MappedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "background_banners")
@Data
@EqualsAndHashCode(callSuper = true)
public class BackgroundBanner extends MappedEntity {
    private BackgroundImage backgroundImage;
    @Column(length = 150)
    private String image;
//    public BackgroundBanner(){
//        this.backgroundImage = BackgroundImage.COMMON_BACKGROUND;
//    }
    @Getter
    @RequiredArgsConstructor
    public enum BackgroundImage{
        COMMON_BACKGROUND("Просто фон"),
        BACKGROUND_IMAGE("Фото на фон");
        private final String value;
    }
}
