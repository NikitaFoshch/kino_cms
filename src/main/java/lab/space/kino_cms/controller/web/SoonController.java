package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.model.Movie;
import lab.space.kino_cms.service.MovieService;
import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("coming-soon")
@RequiredArgsConstructor
public class SoonController {
    private final NavbarService navBarService;
    private final MovieService movieService;
    @GetMapping({"/",""})
    public String showSoonPage(Model model){
        navBarService.addNavbarModel(model);
        List<Movie> moviesComingSoon = movieService.getAllMovieComingSoonByOrderById();
        model.addAttribute("moviesComingSoon", moviesComingSoon);
        return "/web/pages/soon/soon";
    }

    @GetMapping("movie-cart/{id}")
    public String showMovieCartPage(@PathVariable("id") Long movieId,
                                    Model model){
        navBarService.addNavbarModel(model);
        model.addAttribute("movie", movieService.getMovieById(movieId));
        return "/web/pages/soon/soon-cart";
    }
}
