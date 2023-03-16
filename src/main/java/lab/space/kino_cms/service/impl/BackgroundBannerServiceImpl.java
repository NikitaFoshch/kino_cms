package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.BackgroundBanner;
import lab.space.kino_cms.repository.BackgroundBannerRepository;
import lab.space.kino_cms.service.BackgroundBannerService;
import lab.space.kino_cms.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class BackgroundBannerServiceImpl implements BackgroundBannerService {
    private final BackgroundBannerRepository backgroundBannerRepository;

    @Override
    public BackgroundBanner getBackgroundBanner() {
        log.info("---------------Get BackgroundBanner---------------");
        return backgroundBannerRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("BackgroundPage Not Found"));
    }

    @Override
    public void updateBackgroundBanner(BackgroundBanner requestedBackgroundBanner,
                                       MultipartFile requestedTopBanner) {
        log.info("---------------Update Background Banner---------------");

        BackgroundBanner backgroundBanner = getBackgroundBanner();
        backgroundBanner.setBackgroundImage(requestedBackgroundBanner.getBackgroundImage());

        if (FileUtil.saveFile(requestedTopBanner.getOriginalFilename(), requestedTopBanner)) {
            FileUtil.deleteFile(backgroundBanner.getImage());
            backgroundBanner.setImage(requestedTopBanner.getOriginalFilename());
        }

        backgroundBannerRepository.save(backgroundBanner);
        log.info("---------------Success Update Background Banner---------------");
    }
}
