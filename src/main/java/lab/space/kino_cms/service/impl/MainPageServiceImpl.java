package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.MainPage;
import lab.space.kino_cms.repository.MainPageRepository;
import lab.space.kino_cms.service.MainPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainPageServiceImpl implements MainPageService {

    private final MainPageRepository mainPageRepository;

    @Override
    public MainPage getMainePage() {
        return mainPageRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("MainPage not found"));
    }

    @Override
    public void updateMainePage(MainPage requestedMainPage) {
        log.info("---------------Update main page " + requestedMainPage + "---------------");

        MainPage mainPage = getMainePage();
        mainPage.setPhone1(requestedMainPage.getPhone1());
        mainPage.setPhone2(requestedMainPage.getPhone2());
        mainPage.setSeoText(requestedMainPage.getSeoText());
        mainPage.setDisabled(requestedMainPage.isDisabled());
        mainPage.setSeo(requestedMainPage.getSeo());

        mainPageRepository.save(mainPage);
    }
}
