package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.Movie;
import lab.space.kino_cms.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/movies")
public class MoviesController {
    private final MovieService movieService;
    @GetMapping({"/", ""})
    public String showMoviePage(Model model) {
        List<Movie> moviesOngoing = movieService.getAllMovieOngoingByOrderById();
        List<Movie> moviesComingSoon = movieService.getAllMovieComingSoonByOrderById();
        model.addAttribute("moviesOngoing", moviesOngoing);
        model.addAttribute("moviesComingSoon", moviesComingSoon);
        return "/admin-panel/pages/movies/movies";
    }

    @GetMapping("edit/{id}")
    public String showMovieEditPage(@PathVariable("id") Long movieId,
                                         Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "/admin-panel/pages/movies/movie-page";
    }

    @PostMapping("update/{id}")
    public String updateMovie(@PathVariable("id") Long movieId,
                                   @ModelAttribute Movie movie,
                                   @RequestPart MultipartFile mainPicture,
                                   @RequestPart(required = false) MultipartFile galleryPicture1,
                                   @RequestPart(required = false) MultipartFile galleryPicture2,
                                   @RequestPart(required = false) MultipartFile galleryPicture3,
                                   @RequestPart(required = false) MultipartFile galleryPicture4,
                                   @RequestPart(required = false) MultipartFile galleryPicture5) {
        movieService.updateMovieById(movieId, movie,
                mainPicture, galleryPicture1,
                galleryPicture2, galleryPicture3,
                galleryPicture4, galleryPicture5);
        return "redirect:/admin/movie/edit/" + movieId;
    }

    @GetMapping("add")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "/admin-panel/pages/movies/movie-page";
    }
    @PostMapping("save")
    public String saveMovie(@ModelAttribute Movie movie,
                                 @RequestPart MultipartFile mainPicture,
                                 @RequestPart(required = false) MultipartFile galleryPicture1,
                                 @RequestPart(required = false) MultipartFile galleryPicture2,
                                 @RequestPart(required = false) MultipartFile galleryPicture3,
                                 @RequestPart(required = false) MultipartFile galleryPicture4,
                                 @RequestPart(required = false) MultipartFile galleryPicture5) {
        if (movie.getId()==null){
            movieService.saveMovie(movie, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }else {
            movieService.updateMovieById(movie.getId(), movie, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }
        return "redirect:/admin/movies";
    }

    @GetMapping("delete/{id}")
    public String deleteMovieById(@PathVariable("id") Long movieId) {
        movieService.deleteMovieById(movieId);
        return "redirect:/admin/movies";
    }
}
