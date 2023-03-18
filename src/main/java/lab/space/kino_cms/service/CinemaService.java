package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Cinema;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CinemaService {
    List<Cinema> getAllCinema();
    Cinema getCinemaById(Long cinemaId);
    void updateCinemaById(Long cinemaId, Cinema requstedCinema, MultipartFile requestedLogo,
                        MultipartFile requestedTopBanner, MultipartFile requestedGalleryImage1,
                        MultipartFile requestedGalleryImage2, MultipartFile requestedGalleryImage3,
                        MultipartFile requestedGalleryImage4, MultipartFile requestedGalleryImage5);
    void saveCinema(Cinema cinema, MultipartFile requestedLogo,
                    MultipartFile requestedTopBanner, MultipartFile galleryImage1,
                    MultipartFile galleryImage2, MultipartFile galleryImage3,
                    MultipartFile galleryImage4, MultipartFile galleryImage5);
    void deleteCinemaById(Long cinemaId);
    Cinema addCinema();
}
