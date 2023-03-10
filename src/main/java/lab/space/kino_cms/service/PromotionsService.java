package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Promotions;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PromotionsService {
    List<Promotions> getAllPromotions();
    Promotions getPromotionsById(Long promotionsId);
    void updatePromotionsById(Long promotionsId, Promotions requstedPromotions,
                        MultipartFile requstedMainImage, MultipartFile requstedGalleryImage1,
                        MultipartFile requstedGalleryImage2, MultipartFile requstedGalleryImage3,
                        MultipartFile requstedGalleryImage4, MultipartFile requstedGalleryImage5);
    void savePromotions(Promotions promotions, MultipartFile mainImage,
                  MultipartFile galleryImage1, MultipartFile galleryImage2,
                  MultipartFile galleryImage3, MultipartFile galleryImage4,
                  MultipartFile galleryImage5);
    void deletePromotionsById(Long promotionsId);
}
