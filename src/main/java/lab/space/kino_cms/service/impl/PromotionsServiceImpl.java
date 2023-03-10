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
                                     MultipartFile requstedMainImage, MultipartFile requstedGalleryImage1,
                                     MultipartFile requstedGalleryImage2, MultipartFile requstedGalleryImage3,
                                     MultipartFile requstedGalleryImage4, MultipartFile requstedGalleryImage5) {

        log.info("---------------Update Promotions By ID " + promotionsId + "---------------");
        Promotions promotions = getPromotionsById(promotionsId);

        promotions.setName(requstedPromotions.getName());
        promotions.setDescription(requstedPromotions.getDescription());
        promotions.setPublicatedAt(requstedPromotions.getPublicatedAt());
        promotions.setDisabled(requstedPromotions.isDisabled());
        promotions.setTrailerUrl(requstedPromotions.getTrailerUrl());

        if (FileUtil.saveFile(requstedMainImage.getOriginalFilename(), requstedMainImage)) {
            FileUtil.deleteFile(promotions.getMainImage());
            promotions.setMainImage(requstedMainImage.getOriginalFilename());
        }


        if (FileUtil.saveFile(requstedGalleryImage1.getOriginalFilename(), requstedGalleryImage1)) {
            FileUtil.deleteFile(promotions.getGalleryImage1());
            promotions.setGalleryImage1(requstedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage2.getOriginalFilename(), requstedGalleryImage2)) {
            FileUtil.deleteFile(promotions.getGalleryImage2());
            promotions.setGalleryImage2(requstedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage3.getOriginalFilename(), requstedGalleryImage3)) {
            FileUtil.deleteFile(promotions.getGalleryImage3());
            promotions.setGalleryImage3(requstedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage4.getOriginalFilename(), requstedGalleryImage4)) {
            FileUtil.deleteFile(promotions.getMainImage());
            promotions.setGalleryImage4(requstedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage5.getOriginalFilename(), requstedGalleryImage5)) {
            FileUtil.deleteFile(promotions.getMainImage());
            promotions.setGalleryImage5(requstedGalleryImage5.getOriginalFilename());
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
        if (promotions.getMainImage()!=null){
            FileUtil.deleteFile(promotions.getMainImage());
        }
        if (promotions.getGalleryImage1()!=null){
            FileUtil.deleteFile(promotions.getGalleryImage1());
        }
        if (promotions.getGalleryImage2()!=null){
            FileUtil.deleteFile(promotions.getGalleryImage2());
        }
        if (promotions.getGalleryImage3()!=null){
            FileUtil.deleteFile(promotions.getGalleryImage3());
        }
        if (promotions.getGalleryImage4()!=null){
            FileUtil.deleteFile(promotions.getGalleryImage4());
        }
        if (promotions.getGalleryImage5()!=null){
            FileUtil.deleteFile(promotions.getGalleryImage5());
        }

        promotionsRepository.deleteById(promotionsId);
        log.info("---------------Success Delete Promotions By ID " + promotionsId + "---------------");
    }

}
