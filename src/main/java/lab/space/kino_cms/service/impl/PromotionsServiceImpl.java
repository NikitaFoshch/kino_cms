package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.Promotions;
import lab.space.kino_cms.repository.PromotionsRepository;
import lab.space.kino_cms.service.PromotionsService;
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
public class PromotionsServiceImpl implements PromotionsService {
    private final PromotionsRepository promotionsRepository;

    @Override
    public List<Promotions> getAllPromotions() {
        log.info("---------------Get All Promotions---------------");
        return promotionsRepository.findAll(Sort.by(Sort.Direction.DESC, "createAt"));
    }

    @Override
    public Promotions getPromotionsById(Long promotionsId) {
        log.info("---------------Get Promotions By ID " + promotionsId + "---------------");
        return promotionsRepository.findById(promotionsId)
                .orElseThrow(() -> new EntityNotFoundException("Promotions Not Found"));
    }

    @Override
    public void updatePromotionsById(Long promotionsId, Promotions requstedPromotions,
                                     MultipartFile requestedMainImage, MultipartFile requestedGalleryImage1,
                                     MultipartFile requestedGalleryImage2, MultipartFile requestedGalleryImage3,
                                     MultipartFile requestedGalleryImage4, MultipartFile requestedGalleryImage5) {

        log.info("---------------Update Promotions By ID " + promotionsId + "---------------");
        Promotions promotions = getPromotionsById(promotionsId);

        promotions.setName(requstedPromotions.getName());
        promotions.setDescription(requstedPromotions.getDescription());
        promotions.setPublicatedAt(requstedPromotions.getPublicatedAt());
        promotions.setDisabled(requstedPromotions.isDisabled());
        promotions.setTrailerUrl(requstedPromotions.getTrailerUrl());

        if (FileUtil.saveFile(requestedMainImage.getOriginalFilename(), requestedMainImage)) {
            FileUtil.deleteFile(promotions.getMainImage());
            promotions.setMainImage(requestedMainImage.getOriginalFilename());
        }


        if (FileUtil.saveFile(requestedGalleryImage1.getOriginalFilename(), requestedGalleryImage1)) {
            FileUtil.deleteFile(promotions.getGalleryImage1());
            promotions.setGalleryImage1(requestedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage2.getOriginalFilename(), requestedGalleryImage2)) {
            FileUtil.deleteFile(promotions.getGalleryImage2());
            promotions.setGalleryImage2(requestedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage3.getOriginalFilename(), requestedGalleryImage3)) {
            FileUtil.deleteFile(promotions.getGalleryImage3());
            promotions.setGalleryImage3(requestedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage4.getOriginalFilename(), requestedGalleryImage4)) {
            FileUtil.deleteFile(promotions.getGalleryImage4());
            promotions.setGalleryImage4(requestedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requestedGalleryImage5.getOriginalFilename(), requestedGalleryImage5)) {
            FileUtil.deleteFile(promotions.getGalleryImage5());
            promotions.setGalleryImage5(requestedGalleryImage5.getOriginalFilename());
        }

        promotions.setSeo(requstedPromotions.getSeo());

        promotionsRepository.save(promotions);
        log.info("---------------Success Update Promotions By ID " + promotionsId + "---------------");

    }

    @Override
    public void savePromotions(Promotions promotions, MultipartFile mainImage,
                               MultipartFile galleryImage1, MultipartFile galleryImage2,
                               MultipartFile galleryImage3, MultipartFile galleryImage4,
                               MultipartFile galleryImage5) {

        log.info("---------------Save Promotions---------------");
        if (FileUtil.saveFile(mainImage.getOriginalFilename(), mainImage))
            promotions.setMainImage(mainImage.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage1.getOriginalFilename(), galleryImage1))
            promotions.setGalleryImage1(galleryImage1.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage2.getOriginalFilename(), galleryImage2))
            promotions.setGalleryImage2(galleryImage2.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage3.getOriginalFilename(), galleryImage3))
            promotions.setGalleryImage3(galleryImage3.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage4.getOriginalFilename(), galleryImage4))
            promotions.setGalleryImage4(galleryImage4.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage5.getOriginalFilename(), galleryImage5))
            promotions.setGalleryImage5(galleryImage5.getOriginalFilename());

        promotionsRepository.save(promotions);
        log.info("---------------Success Save Promotions---------------");

    }

    @Override
    public void deletePromotionsById(Long promotionsId) {

        log.info("---------------Delete Promotions By ID " + promotionsId + "---------------");
        Promotions promotions = getPromotionsById(promotionsId);
        if (promotions.getMainImage() != null) {
            FileUtil.deleteFile(promotions.getMainImage());
        }
        if (promotions.getGalleryImage1() != null) {
            FileUtil.deleteFile(promotions.getGalleryImage1());
        }
        if (promotions.getGalleryImage2() != null) {
            FileUtil.deleteFile(promotions.getGalleryImage2());
        }
        if (promotions.getGalleryImage3() != null) {
            FileUtil.deleteFile(promotions.getGalleryImage3());
        }
        if (promotions.getGalleryImage4() != null) {
            FileUtil.deleteFile(promotions.getGalleryImage4());
        }
        if (promotions.getGalleryImage5() != null) {
            FileUtil.deleteFile(promotions.getGalleryImage5());
        }

        promotionsRepository.deleteById(promotionsId);
        log.info("---------------Success Delete Promotions By ID " + promotionsId + "---------------");
    }

}
