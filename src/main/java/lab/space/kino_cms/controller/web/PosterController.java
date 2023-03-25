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

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("poster")
@RequiredArgsConstructor
public class PosterController {
    private final NavbarService navBarService;
    private final MovieService movieService;
    @GetMapping({"/",""})
    public String showPosterPage(Model model){
        navBarService.addNavbarModel(model);
        List<Movie> moviesOngoing = movieService.getAllMovieOngoingByOrderById();
        model.addAttribute("moviesOngoing", moviesOngoing);
        return "/web/pages/poster/poster";
    }
    @GetMapping("movie-cart/{id}")
    public String showMovieCartPage(@PathVariable("id") Long movieId,
                                    Model model){
        navBarService.addNavbarModel(model);
        LocalDate date = LocalDate.now();
        model.addAttribute("movie", movieService.getMovieById(movieId));
        model.addAttribute("date", date);
        return "/web/pages/poster/movie-cart";
    }
}
