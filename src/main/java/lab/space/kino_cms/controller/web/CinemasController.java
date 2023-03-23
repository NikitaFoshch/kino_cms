package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.model.Hall;
import lab.space.kino_cms.service.CinemaService;
import lab.space.kino_cms.service.HallService;
import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("cinemas")
@RequiredArgsConstructor
public class CinemasController {
    private final CinemaService cinemaService;
    private final HallService hallService;
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showCinemasPage(Model model){
        navBarService.addNavbarModel(model);
        List<Cinema> cinemas = cinemaService.getAllCinema();
        model.addAttribute("cinemas", cinemas);
        return "/web/pages/cinemas/cinemas";
    }
    @GetMapping("cinema-cart/{id}")
    public String showCinemasCartPage(@PathVariable("id") Long cinemaId,
                                      Model model){
        navBarService.addNavbarModel(model);
        Cinema cinema = cinemaService.getCinemaById(cinemaId);
        model.addAttribute("cinema", cinema);
        model.addAttribute("countHalls", hallService.getHallsByCinemaAndDisabledTrue(cinemaId).size());
        model.addAttribute("hallsByCinema", hallService.getAllHallByCinemaByOrderByCreatedAtAsc(cinema));
        return "/web/pages/cinemas/cinema-cart";
    }
    @GetMapping("{cinemaId}/hall-cart/{id}")
    public String showHallCartPage(@PathVariable("cinemaId") Long cinemaId,
                                   @PathVariable("id") Long hallId,
                                   Model model){
        navBarService.addNavbarModel(model);
        Hall hall = hallService.getHallById(hallId);
        model.addAttribute("hall", hall);
        model.addAttribute("cinemaId", cinemaId);
        return "/web/pages/cinemas/hall-cart";
    }
}
