package lab.space.kino_cms.service;

import lab.space.kino_cms.model.MainPage;

public interface MainPageService {
    MainPage getMainePageById(Long seoId);
    void updateMainePageById(Long seoId, MainPage requestedMainPage);
}
