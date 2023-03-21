package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("poster")
@RequiredArgsConstructor
public class PosterController {
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showPosterPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/poster/poster";
    }
    @GetMapping("movie-cart")
    public String showMovieCartPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/poster/movie-cart";
    }
}
