package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.Movie;
import lab.space.kino_cms.repository.MovieRepository;
import lab.space.kino_cms.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie Not Found By ID " + movieId));
    }

    @Override
    public void updateMovieById(Long movieId, Movie requestedMovie) {
        log.info("---------------Update Movie---------------");


    }
}
