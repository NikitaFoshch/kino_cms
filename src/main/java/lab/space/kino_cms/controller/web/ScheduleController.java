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
@RequestMapping("schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final NavbarService navBarService;
    private final MovieService movieService;
    @GetMapping({"/",""})
    public String showSchedulePage(Model model){
        navBarService.addNavbarModel(model);
        List<Movie> movies = movieService.getAllMovieOngoingByOrderById();
        LocalDate date = LocalDate.now();
        model.addAttribute("date", date);
        model.addAttribute("movies", movies);
        return "/web/pages/schedule/schedule";
    }
    @GetMapping("ticket-booking/{id}")
    public String showTicketBookingPage(@PathVariable("id") Long movieId,
                                        Model model){
        navBarService.addNavbarModel(model);
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "/web/pages/schedule/ticket-booking";
    }
}
