package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.News;
import lab.space.kino_cms.repository.NewsRepository;
import lab.space.kino_cms.service.NewsService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public List<News> getAllNews() {
        log.info("---------------Get All news---------------");
        return newsRepository.findAll(Sort.by(Sort.Direction.DESC, "createAt"));
    }

    @Override
    public News getNewsById(Long newsId) {
        log.info("---------------Get News By ID " + newsId + "---------------");
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new EntityNotFoundException("News Not Found"));

    }

    @Override
    public void updateNewsById(Long newsId, News requstedNews,
                                   MultipartFile requstedMainImage, MultipartFile requstedGalleryImage1,
                                   MultipartFile requstedGalleryImage2, MultipartFile requstedGalleryImage3,
                                   MultipartFile requstedGalleryImage4, MultipartFile requstedGalleryImage5) {
        log.info("---------------Update News By ID " + newsId + "---------------");
        News news = getNewsById(newsId);

        news.setName(requstedNews.getName());
        news.setDescription(requstedNews.getDescription());
        news.setPublicatedAt(requstedNews.getPublicatedAt());
        news.setDisabled(requstedNews.isDisabled());
        news.setTrailerUrl(requstedNews.getTrailerUrl());

        if (FileUtil.saveFile(requstedMainImage.getOriginalFilename(), requstedMainImage)){
            FileUtil.deleteFile(news.getMainImage());
            news.setMainImage(requstedMainImage.getOriginalFilename());
        }


        if (FileUtil.saveFile(requstedGalleryImage1.getOriginalFilename(), requstedGalleryImage1)) {
            FileUtil.deleteFile(news.getGalleryImage1());
            news.setGalleryImage1(requstedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage2.getOriginalFilename(), requstedGalleryImage2)) {
            FileUtil.deleteFile(news.getGalleryImage2());
            news.setGalleryImage2(requstedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage3.getOriginalFilename(), requstedGalleryImage3)) {
            FileUtil.deleteFile(news.getGalleryImage3());
            news.setGalleryImage3(requstedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage4.getOriginalFilename(), requstedGalleryImage4)) {
            FileUtil.deleteFile(news.getMainImage());
            news.setGalleryImage4(requstedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage5.getOriginalFilename(), requstedGalleryImage5)) {
            FileUtil.deleteFile(news.getMainImage());
            news.setGalleryImage5(requstedGalleryImage5.getOriginalFilename());
        }

        news.setSeo(requstedNews.getSeo());

        newsRepository.save(news);
        log.info("---------------Success Update News By ID " + newsId + "---------------");
    }

    @Override
    public void saveNews(News news, MultipartFile mainImage,
                         MultipartFile galleryImage1, MultipartFile galleryImage2,
                         MultipartFile galleryImage3, MultipartFile galleryImage4,
                         MultipartFile galleryImage5) {
        log.info("---------------Save News---------------");
        if (FileUtil.saveFile(mainImage.getOriginalFilename(), mainImage))
            news.setMainImage(mainImage.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage1.getOriginalFilename(), galleryImage1))
            news.setGalleryImage1(galleryImage1.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage2.getOriginalFilename(), galleryImage2))
            news.setGalleryImage2(galleryImage2.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage3.getOriginalFilename(), galleryImage3))
            news.setGalleryImage3(galleryImage3.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage4.getOriginalFilename(), galleryImage4))
            news.setGalleryImage4(galleryImage4.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage5.getOriginalFilename(), galleryImage5))
            news.setGalleryImage5(galleryImage5.getOriginalFilename());

        newsRepository.save(news);
        log.info("---------------Success Save News---------------");
    }

    @Override
    public void deleteNewsById(Long newsId) {
        log.info("---------------Delete News By ID " + newsId + "---------------");
        News news = getNewsById(newsId);
        if (news.getMainImage()!=null){
            FileUtil.deleteFile(news.getMainImage());
        }
        if (news.getGalleryImage1()!=null){
            FileUtil.deleteFile(news.getGalleryImage1());
        }
        if (news.getGalleryImage2()!=null){
            FileUtil.deleteFile(news.getGalleryImage2());
        }
        if (news.getGalleryImage3()!=null){
            FileUtil.deleteFile(news.getGalleryImage3());
        }
        if (news.getGalleryImage4()!=null){
            FileUtil.deleteFile(news.getGalleryImage4());
        }
        if (news.getGalleryImage5()!=null){
            FileUtil.deleteFile(news.getGalleryImage5());
        }

        newsRepository.deleteById(newsId);
        log.info("---------------Success Delete News By ID " + newsId + "---------------");
    }

}
