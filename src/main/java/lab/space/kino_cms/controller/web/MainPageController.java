package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.model.BackgroundBanner;
import lab.space.kino_cms.model.Movie;
import lab.space.kino_cms.model.NewsBanner;
import lab.space.kino_cms.model.TopBanner;
import lab.space.kino_cms.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping({"/",""})
@RequiredArgsConstructor
public class MainPageController {
    private final NavbarService navBarService;
    private final TopBannerService topBannerService;
    private final BackgroundBannerService backgroundBannerService;
    private final NewsBannerService newsBannerService;
    private final MovieService movieService;
    @GetMapping
    public String showMainPage(Model model){
        navBarService.addNavbarModel(model);
        List<Movie> moviesOngoing = movieService.getAllMovieOngoingByOrderById();
        List<Movie> moviesComingSoon = movieService.getAllMovieComingSoonByOrderById();
        TopBanner topBanner = topBannerService.getTopBanner();
        BackgroundBanner backgroundBanner = backgroundBannerService.getBackgroundBanner();
        NewsBanner newsBanner = newsBannerService.getNewsBanner();
        LocalDate date = LocalDate.now();
        model.addAttribute("moviesOngoing", moviesOngoing);
        model.addAttribute("moviesComingSoon", moviesComingSoon);
        model.addAttribute("topBanner", topBanner);
        model.addAttribute("backgroundBanner", backgroundBanner);
        model.addAttribute("newsBanner", newsBanner);
        model.addAttribute("date", date);
        return "/web/pages/main-page/main-page";
    }
}
