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
        log.info("---------------Get All News Order by CreateAt---------------");
        return newsRepository.findAll(Sort.by(Sort.Direction.DESC, "createAt"));
    }

    @Override
    public List<News> getNewsByOrderByPublicatedAtDesc() {
        log.info("---------------Get All News Order by PublicateAt---------------");
        return newsRepository.getNewsByOrderByPublicatedAtDesc();
    }

    @Override
    public News getNewsById(Long newsId) {
        log.info("---------------Get News By ID " + newsId + "---------------");
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new EntityNotFoundException("News Not Found"));

    }

    @Override
    public void updateNewsById(Long newsId, News requstedNews,
                               MultipartFile requestedMainImage, MultipartFile requestedGalleryImage1,
                               MultipartFile requestedGalleryImage2, MultipartFile requestedGalleryImage3,
                               MultipartFile requestedGalleryImage4, MultipartFile requestedGalleryImage5) {
        log.info("---------------Update News By ID " + newsId + "---------------");
        News news = getNewsById(newsId);

        news.setName(requstedNews.getName());
        news.setDescription(requstedNews.getDescription());
        news.setPublicatedAt(requstedNews.getPublicatedAt());
        news.setDisabled(requstedNews.isDisabled());
        news.setTrailerUrl(requstedNews.getTrailerUrl());

        if (FileUtil.saveFile(requestedMainImage.getOriginalFilename(), requestedMainImage)) {
            FileUtil.deleteFile(news.getMainImage());
            news.setMainImage(requestedMainImage.getOriginalFilename());
        }


        if (FileUtil.saveFile(requestedGalleryImage1.getOriginalFilename(), requestedGalleryImage1)) {
            FileUtil.deleteFile(news.getGalleryImage1());
            news.setGalleryImage1(requestedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage2.getOriginalFilename(), requestedGalleryImage2)) {
            FileUtil.deleteFile(news.getGalleryImage2());
            news.setGalleryImage2(requestedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage3.getOriginalFilename(), requestedGalleryImage3)) {
            FileUtil.deleteFile(news.getGalleryImage3());
            news.setGalleryImage3(requestedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage4.getOriginalFilename(), requestedGalleryImage4)) {
            FileUtil.deleteFile(news.getGalleryImage4());
            news.setGalleryImage4(requestedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage5.getOriginalFilename(), requestedGalleryImage5)) {
            FileUtil.deleteFile(news.getGalleryImage5());
            news.setGalleryImage5(requestedGalleryImage5.getOriginalFilename());
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
        if (news.getMainImage() != null) {
            FileUtil.deleteFile(news.getMainImage());
        }
        if (news.getGalleryImage1() != null) {
            FileUtil.deleteFile(news.getGalleryImage1());
        }
        if (news.getGalleryImage2() != null) {
            FileUtil.deleteFile(news.getGalleryImage2());
        }
        if (news.getGalleryImage3() != null) {
            FileUtil.deleteFile(news.getGalleryImage3());
        }
        if (news.getGalleryImage4() != null) {
            FileUtil.deleteFile(news.getGalleryImage4());
        }
        if (news.getGalleryImage5() != null) {
            FileUtil.deleteFile(news.getGalleryImage5());
        }

        newsRepository.deleteById(newsId);
        log.info("---------------Success Delete News By ID " + newsId + "---------------");
    }

}
