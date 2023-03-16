package lab.space.kino_cms.service;

import lab.space.kino_cms.model.NewsBanner;

public interface NewsBannerService {
    NewsBanner getNewsBanner();

    void updateNewsBanner(NewsBanner newsBanner);
}
