package lab.space.kino_cms.service;

import lab.space.kino_cms.model.News;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();
    News getNewsById(Long newsId);
    void updateNewsById(Long newsId, News requstedNews,
                            MultipartFile requstedMainImage, MultipartFile requstedGalleryImage1,
                            MultipartFile requstedGalleryImage2, MultipartFile requstedGalleryImage3,
                            MultipartFile requstedGalleryImage4, MultipartFile requstedGalleryImage5);
    void saveNews(News news, MultipartFile mainImage,
                  MultipartFile galleryImage1, MultipartFile galleryImage2,
                  MultipartFile galleryImage3, MultipartFile galleryImage4,
                  MultipartFile galleryImage5);
    void deleteNewsById(Long newsId);
}
