package lab.space.kino_cms.service;

import lab.space.kino_cms.model.BackgroundBanner;
import org.springframework.web.multipart.MultipartFile;

public interface BackgroundBannerService {
    BackgroundBanner getBackgroundBanner();
    void updateBackgroundBanner(BackgroundBanner requestedBackgroundBanner,
                                MultipartFile requestedTopBanner);
}
