package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("poster")
public class PosterController {
    @GetMapping({"/",""})
    public String showPosterPage(){
        return "/web/pages/poster/poster";
    }
    @GetMapping("movie-cart")
    public String showMovieCartPage(){
        return "/web/pages/poster/movie-cart";
    }
}
