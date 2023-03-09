package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Movie;

public interface MovieService {
    Movie getMovieById(Long movieId);
    void updateMovieById(Long movieId,Movie requestedMovie);
}
