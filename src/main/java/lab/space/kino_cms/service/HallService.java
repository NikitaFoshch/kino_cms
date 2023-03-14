package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Hall;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HallService {
    Hall getHallById(Long hallId);

    List<Hall> getAllHallByOrderByIdAsc();

    void updateHallById(Long hallId, Hall requstedHall, MultipartFile requestedSchema,
                        MultipartFile requestedTopBanner, MultipartFile requestedGalleryImage1,
                        MultipartFile requestedGalleryImage2, MultipartFile requestedGalleryImage3,
                        MultipartFile requestedGalleryImage4, MultipartFile requestedGalleryImage5);

    void saveHall(Hall hall, MultipartFile requestedSchema,
                  MultipartFile requestedTopBanner, MultipartFile galleryImage1,
                  MultipartFile galleryImage2, MultipartFile galleryImage3,
                  MultipartFile galleryImage4, MultipartFile galleryImage5);

    void deleteHallById(Long hallId);
}
