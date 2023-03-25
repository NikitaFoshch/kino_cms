package lab.space.kino_cms;

import lab.space.kino_cms.model.*;
import lab.space.kino_cms.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static lab.space.kino_cms.model.BackgroundBanner.BackgroundImage;

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
    private final EmailDistributionRepository emailDistributionRepository;
    private final SmsDistributionRepository smsDistributionRepository;

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
            BackgroundBanner backgroundBanner = new BackgroundBanner();
            backgroundBanner.setBackgroundImage(BackgroundImage.COMMON_BACKGROUND);
            backgroundBannerRepository.save(backgroundBanner);
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

            Movie movie = new Movie();
            LocalDate release = LocalDate.now();
            movie.setRelease(release);
            movie.setName("Название фильма");
            movieRepository.save(movie);

            Movie movie1 = new Movie();
            release = release.plusWeeks(2);
            movie1.setRelease(release);
            movie1.setName("Название фильма");
            movieRepository.save(movie1);

            log.info("Initial Movie Created");
        } else log.info("Movie Found");

        log.info("Try To Find Cinema");
        if (cinemaRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("Cinema Not Found");
            Cinema cinema = new Cinema();
            cinema.setDefault(true);
            cinema.getHalls().get(0).setDefault(true);
            cinema.getHalls().get(0).setName("1 Зал");
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
            contactsPage.setDisabled(true);
            contactsPageRepository.save(contactsPage);
            log.info("Initial Contacts Created");
        } else log.info("Contacts Found");

        log.info("Try To Find EmailDistribution");
        if (emailDistributionRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("EmailDistribution Not Found");
            EmailDistribution emailDistribution = new EmailDistribution();
            for (int i = 1; i <= 5; i++) {
                Template template = new Template();
                template.setName("Тестовая рассылка_" + i);
                emailDistribution.getTemplatesList().add(template);
            }
            emailDistribution.setPickUsersSend(1);
            emailDistribution.setPickTemplateSend(1L);
            emailDistributionRepository.save(emailDistribution);
            log.info("Initial EmailDistribution Created");
        } else log.info("EmailDistribution Found");

        log.info("Try To Find SmsDistribution");
        if (smsDistributionRepository.findFirstByOrderByIdAsc().isEmpty()) {
            log.warn("SmsDistribution Not Found");
            SmsDistribution smsDistribution = new SmsDistribution();
            smsDistribution.setPickUsersSend(1);
            smsDistribution.setText("");
            smsDistributionRepository.save(smsDistribution);
            log.info("Initial SmsDistribution Created");
        } else log.info("SmsDistribution Found");
    }
}
