package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("movies")
public class MoviesController {
    @GetMapping({"/",""})
    public String showMoviesPage(){
        return "/admin-panel/pages/movies/movies";
    }

    @GetMapping("movie-edit")
    public String showMovieEditPage(){
        return "/admin-panel/pages/movies/movie-page";
    }
}
