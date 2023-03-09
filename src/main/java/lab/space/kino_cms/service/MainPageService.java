package lab.space.kino_cms.service;

import lab.space.kino_cms.model.MainPage;

public interface MainPageService {
    MainPage getMainePage();
    void updateMainePage(MainPage requestedMainPage);
}
