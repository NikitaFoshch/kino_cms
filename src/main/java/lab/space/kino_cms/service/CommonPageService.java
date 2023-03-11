package lab.space.kino_cms.service;

import lab.space.kino_cms.model.CommonPage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommonPageService {
    List<CommonPage> getAllCommonPageByDefaultTrueByOrderByIdAsc();
    List<CommonPage> getAllCommonPageByDefaultFalseByOrderByIdAsc();
    CommonPage getCommonPageById(Long commonPageId);
    void updateCommonPageById(Long commonPageId, CommonPage requstedCommonPage,
                        MultipartFile requstedMainImage, MultipartFile requstedGalleryImage1,
                        MultipartFile requstedGalleryImage2, MultipartFile requstedGalleryImage3,
                        MultipartFile requstedGalleryImage4, MultipartFile requstedGalleryImage5);
    void saveCommonPage(CommonPage commonPage, MultipartFile mainImage,
                  MultipartFile galleryImage1, MultipartFile galleryImage2,
                  MultipartFile galleryImage3, MultipartFile galleryImage4,
                  MultipartFile galleryImage5);
    void deleteCommonPageById(Long commonPageId);
}
