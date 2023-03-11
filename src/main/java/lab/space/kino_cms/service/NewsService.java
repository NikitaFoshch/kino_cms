package lab.space.kino_cms.service;

import lab.space.kino_cms.model.News;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();
    News getNewsById(Long newsId);
    void updateNewsById(Long newsId, News requstedNews,
                            MultipartFile requestedMainImage, MultipartFile requestedGalleryImage1,
                            MultipartFile requestedGalleryImage2, MultipartFile requestedGalleryImage3,
                            MultipartFile requestedGalleryImage4, MultipartFile requestedGalleryImage5);
    void saveNews(News news, MultipartFile mainImage,
                  MultipartFile galleryImage1, MultipartFile galleryImage2,
                  MultipartFile galleryImage3, MultipartFile galleryImage4,
                  MultipartFile galleryImage5);
    void deleteNewsById(Long newsId);
}
