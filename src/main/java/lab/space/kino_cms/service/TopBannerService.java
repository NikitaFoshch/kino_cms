package lab.space.kino_cms.service;

import lab.space.kino_cms.model.TopBanner;

public interface TopBannerService {
    TopBanner getTopBanner();

    void updateTopBanner(TopBanner topBanner);
}
