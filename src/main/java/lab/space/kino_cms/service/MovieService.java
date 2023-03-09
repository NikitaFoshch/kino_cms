package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Movie;

public interface MovieService {
    Movie getMovie();
    void updateMovieById(Movie requestedMovie);
}
