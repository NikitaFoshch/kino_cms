package lab.space.kino_cms;

import lab.space.kino_cms.model.*;
import lab.space.kino_cms.repository.BackgroundBannerRepository;
import lab.space.kino_cms.repository.CinemaRepository;
import lab.space.kino_cms.repository.MainPageRepository;
import lab.space.kino_cms.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init implements CommandLineRunner {
    private final MainPageRepository mainPageRepository;
    private final BackgroundBannerRepository backgroundBannerRepository;
    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    @Override
    public void run(String... args) throws Exception {
        if(mainPageRepository.findFirstByOrderByIdAsc().isEmpty()){
            mainPageRepository.save(new MainPage(new Seo()));
        }
        if(backgroundBannerRepository.findFirstByOrderByIdAsc().isEmpty()){
            backgroundBannerRepository.save(new BackgroundBanner());
        }
        if(movieRepository.findFirstByOrderByIdAsc().isEmpty()){
            for (int i = 0; i < 12; i++) {
                movieRepository.save(new Movie(new Seo()));
            }
        }
        if(cinemaRepository.findFirstByOrderByIdAsc().isEmpty()){
            cinemaRepository.save(new Cinema(new Hall(new Seo()),new Seo()));
        }


    }
}
