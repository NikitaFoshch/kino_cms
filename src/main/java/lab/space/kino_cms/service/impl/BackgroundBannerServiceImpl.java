package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.BackgroundBanner;
import lab.space.kino_cms.repository.BackgroundBannerRepository;
import lab.space.kino_cms.service.BackgroundBannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BackgroundBannerServiceImpl implements BackgroundBannerService {
    private final BackgroundBannerRepository backgroundBannerRepository;

    @Override
    public BackgroundBanner getBackgroundBanner() {
        return backgroundBannerRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("BackgroundPage Not Found"));
    }

    @Override
    public void updateBackgroundBanner(BackgroundBanner requestedBackgroundBanner) {
        log.info("---------------Update Background Banner---------------");

        BackgroundBanner backgroundBanner = getBackgroundBanner();
        backgroundBanner.setBackgroundImage(requestedBackgroundBanner.getBackgroundImage());
        backgroundBanner.setImage(requestedBackgroundBanner.getImage());

        backgroundBannerRepository.save(backgroundBanner);
    }
}
