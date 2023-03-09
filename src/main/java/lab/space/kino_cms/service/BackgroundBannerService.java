package lab.space.kino_cms.service;

import lab.space.kino_cms.model.BackgroundBanner;

public interface BackgroundBannerService {
    BackgroundBanner getBackgroundBanner();
    void updateBackgroundBanner(BackgroundBanner requestedBackgroundBanner);
}
