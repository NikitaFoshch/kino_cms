package lab.space.kino_cms;

import lab.space.kino_cms.model.*;
import lab.space.kino_cms.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class Init implements CommandLineRunner {
    private final MainPageRepository mainPageRepository;
    private final TopBannerRepository topBannerRepository;
    private final BackgroundBannerRepository backgroundBannerRepository;
    private final NewsBannerRepository newsBannerRepository;
    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final CityRepository cityRepository;
    private final CommonPageRepository commonPageRepository;
    private final ContactsPageRepository contactsPageRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Try To Find MainPage");
        if (mainPageRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("MainPage Not Found");
            mainPageRepository.save(new MainPage());
            log.info("Initial MainPage Created");
        } else log.info("MainPage Found");

        log.info("Try To Find TopBanner");
        if (topBannerRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("TopBanner Not Found");
            TopBanner topBanner = new TopBanner();
            topBanner.setRotatingSpeed(10);
            topBannerRepository.save(topBanner);
            log.info("Initial TopBanner Created");
        } else log.info("TopBanner Found");

        log.info("Try To Find BackgroundBanner");
        if (backgroundBannerRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("BackgroundBanner Not Found");
            backgroundBannerRepository.save(new BackgroundBanner());
            log.info("Initial BackgroundBanner Created");
        } else log.info("BackgroundBanner Found");

        log.info("Try To Find NewsBanner");
        if (newsBannerRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("NewsBanner Not Found");
            NewsBanner newsBanner = new NewsBanner();
            newsBanner.setRotatingSpeed(10);
            newsBannerRepository.save(newsBanner);
            log.info("Initial NewsBanner Created");
        } else log.info("NewsBanner Found");

        log.info("Try To Find Movie");
        if (movieRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("Movie Not Found");
            for (int i = 0; i < 12; i++) {
                Movie movie = new Movie();
                movie.setName("Название фильма");
                movieRepository.save(movie);
            }
            log.info("Initial Movie Created");
        } else log.info("Movie Found");

        log.info("Try To Find Cinema");
        if (cinemaRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("Cinema Not Found");
            Cinema cinema = new Cinema();
            cinema.setDefault(true);
            cinema.getHalls().get(0).setDefault(true);
            cinema.setName("Стандартный Кинотеарт");
            cinemaRepository.save(cinema);
            log.info("Initial Cinema Created");
        } else log.info("Cinema Found");

        log.info("Try To Find City");
        if (cityRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("City Not Found");
            List.of("Одесса", "Киев", "Львов", "Николаев", "Днепр", "Харьков", "Запорожье")
                    .forEach(name -> cityRepository.save(new City(name)));
            log.info("Initial City Created");
        } else log.info("City Found");

        log.info("Try To Find CommonPage");
        if (commonPageRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("CommonPage Not Found");
            List<String> titles =
                    List.of("О кинотеатре", "Кафе - Бар", "Vip - зал",
                            "Реклама", "Детская комната");
            for (int i = 0; i < 5; i++) {
                CommonPage commonPage = new CommonPage();
                commonPage.setName(titles.get(i));
                commonPage.setDefault(true);
                commonPageRepository.save(commonPage);
            }
            log.info("Initial CommonPage Created");
        } else log.info("CommonPage Found");

        log.info("Try To Find Contacts");
        if (contactsPageRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("Contacts Not Found");
            CinemaInfo cinemaInfo = new CinemaInfo();
            cinemaInfo.setDefault(true);
            cinemaInfo.setDisabled(true);
            ContactsPage contactsPage = new ContactsPage();
            contactsPage.getCinemaInfoList().add(cinemaInfo);
            contactsPageRepository.save(contactsPage);
            log.info("Initial Contacts Created");
        } else log.info("Contacts Found");
    }
}
