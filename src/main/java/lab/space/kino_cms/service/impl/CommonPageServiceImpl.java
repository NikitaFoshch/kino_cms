package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.CommonPage;
import lab.space.kino_cms.repository.CommonPageRepository;
import lab.space.kino_cms.service.CommonPageService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonPageServiceImpl implements CommonPageService {
    private final CommonPageRepository commonPageRepository;

    @Override
    public List<CommonPage> getAllCommonPageByDefaultTrueByOrderByIdAsc() {
        log.info("---------------Get All CommonPage By Default True By Order By Id ASC---------------");
        return commonPageRepository.getCommonPageByDefaultTrueByOrderByIdAsc();
    }
    @Override
    public List<CommonPage> getAllCommonPageByDefaultFalseByOrderByIdAsc() {
        log.info("---------------Get All CommonPage By Default False By Order By Id ASC---------------");
        return commonPageRepository.getCommonPageByDefaultFalseByOrderByIdAsc();
    }

    @Override
    public CommonPage getCommonPageById(Long commonPageId) {
        log.info("---------------Get CommonPage By ID " + commonPageId + "---------------");
        return commonPageRepository.findById(commonPageId)
                .orElseThrow(() -> new EntityNotFoundException("CommonPage Not Found"));
    }

    @Override
    public void updateCommonPageById(Long commonPageId, CommonPage requstedCommonPage,
                                     MultipartFile requstedMainImage, MultipartFile requstedGalleryImage1,
                                     MultipartFile requstedGalleryImage2, MultipartFile requstedGalleryImage3,
                                     MultipartFile requstedGalleryImage4, MultipartFile requstedGalleryImage5) {

        log.info("---------------Update CommonPage By ID " + commonPageId + "---------------");
        CommonPage commonPage = getCommonPageById(commonPageId);

        commonPage.setName(requstedCommonPage.getName());
        commonPage.setDescription(requstedCommonPage.getDescription());
        commonPage.setDisabled(requstedCommonPage.isDisabled());

        if (FileUtil.saveFile(requstedMainImage.getOriginalFilename(), requstedMainImage)) {
            FileUtil.deleteFile(commonPage.getMainImage());
            commonPage.setMainImage(requstedMainImage.getOriginalFilename());
        }


        if (FileUtil.saveFile(requstedGalleryImage1.getOriginalFilename(), requstedGalleryImage1)) {
            FileUtil.deleteFile(commonPage.getGalleryImage1());
            commonPage.setGalleryImage1(requstedGalleryImage1.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage2.getOriginalFilename(), requstedGalleryImage2)) {
            FileUtil.deleteFile(commonPage.getGalleryImage2());
            commonPage.setGalleryImage2(requstedGalleryImage2.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage3.getOriginalFilename(), requstedGalleryImage3)) {
            FileUtil.deleteFile(commonPage.getGalleryImage3());
            commonPage.setGalleryImage3(requstedGalleryImage3.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage4.getOriginalFilename(), requstedGalleryImage4)) {
            FileUtil.deleteFile(commonPage.getMainImage());
            commonPage.setGalleryImage4(requstedGalleryImage4.getOriginalFilename());
        }

        if (FileUtil.saveFile(requstedGalleryImage5.getOriginalFilename(), requstedGalleryImage5)) {
            FileUtil.deleteFile(commonPage.getMainImage());
            commonPage.setGalleryImage5(requstedGalleryImage5.getOriginalFilename());
        }

        commonPage.setSeo(requstedCommonPage.getSeo());

        commonPageRepository.save(commonPage);
        log.info("---------------Success Update CommonPage By ID " + commonPageId + "---------------");
    }

    @Override
    public void saveCommonPage(CommonPage commonPage, MultipartFile mainImage,
                               MultipartFile galleryImage1, MultipartFile galleryImage2,
                               MultipartFile galleryImage3, MultipartFile galleryImage4,
                               MultipartFile galleryImage5) {

        log.info("---------------Save CommonPage---------------");
        if (FileUtil.saveFile(mainImage.getOriginalFilename(), mainImage))
            commonPage.setMainImage(mainImage.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage1.getOriginalFilename(), galleryImage1))
            commonPage.setGalleryImage1(galleryImage1.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage2.getOriginalFilename(), galleryImage2))
            commonPage.setGalleryImage2(galleryImage2.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage3.getOriginalFilename(), galleryImage3))
            commonPage.setGalleryImage3(galleryImage3.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage4.getOriginalFilename(), galleryImage4))
            commonPage.setGalleryImage4(galleryImage4.getOriginalFilename());

        if (FileUtil.saveFile(galleryImage5.getOriginalFilename(), galleryImage5))
            commonPage.setGalleryImage5(galleryImage5.getOriginalFilename());

        commonPageRepository.save(commonPage);
        log.info("---------------Success Save CommonPage---------------");
    }

    @Override
    public void deleteCommonPageById(Long commonPageId) {
        log.info("---------------Delete CommonPage By ID " + commonPageId + "---------------");
        CommonPage commonPage = getCommonPageById(commonPageId);
        if (!commonPage.isDefault()) {
            if (commonPage.getMainImage() != null) {
                FileUtil.deleteFile(commonPage.getMainImage());
            }
            if (commonPage.getGalleryImage1() != null) {
                FileUtil.deleteFile(commonPage.getGalleryImage1());
            }
            if (commonPage.getGalleryImage2() != null) {
                FileUtil.deleteFile(commonPage.getGalleryImage2());
            }
            if (commonPage.getGalleryImage3() != null) {
                FileUtil.deleteFile(commonPage.getGalleryImage3());
            }
            if (commonPage.getGalleryImage4() != null) {
                FileUtil.deleteFile(commonPage.getGalleryImage4());
            }
            if (commonPage.getGalleryImage5() != null) {
                FileUtil.deleteFile(commonPage.getGalleryImage5());
            }

            commonPageRepository.deleteById(commonPageId);
            log.info("---------------Success Delete CommonPage By ID " + commonPageId + "---------------");
        } else log.warn("Failure Attempt Of Deleting Default CommonPage");
    }
}
