package lab.space.kino_cms.service.impl;

import lab.space.kino_cms.model.MainPage;
import lab.space.kino_cms.model.Seo;
import lab.space.kino_cms.repository.MainPageRepository;
import lab.space.kino_cms.service.MainPageService;
import lab.space.kino_cms.service.SeoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainPageServiceImpl implements MainPageService {

    private final MainPageRepository mainPageRepository;
    private final SeoService seoService;

    @Override
    public MainPage getMainePageById(Long seoId) {
        Optional<MainPage> optionalMainPage = mainPageRepository.findById(seoId);
        return optionalMainPage.get();
    }

    @Override
    public void updateMainePageById(Long mainPageId, MainPage requestedMainPage) {
        log.info("Update main page " + requestedMainPage);

        Optional<MainPage> optionalMainPage = mainPageRepository.findById(mainPageId);
        MainPage mainPage = optionalMainPage.get();
        mainPage.setPhone1(requestedMainPage.getPhone1());
        mainPage.setPhone2(requestedMainPage.getPhone2());
        mainPage.setSeoText(requestedMainPage.getSeoText());
        mainPage.setSwitcher(requestedMainPage.isSwitcher());


        Seo seo = mainPage.getSeo();
        Seo requastedSeo = requestedMainPage.getSeo();
        if (requastedSeo != null) {
            seo.setUrl(requastedSeo.getUrl());
            seo.setTitle(requastedSeo.getTitle());
            seo.setKeywords(requastedSeo.getKeywords());
            seo.setDescription(requastedSeo.getDescription());
        }
        mainPageRepository.save(mainPage);

    }
}
