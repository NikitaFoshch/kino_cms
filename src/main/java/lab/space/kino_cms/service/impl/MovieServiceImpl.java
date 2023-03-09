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
    public Movie getMovie() {
        return movieRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new EntityNotFoundException("Movie mot found"));
    }

    @Override
    public void updateMovieById(Movie requestedMovie) {
        log.info("---------------Update Movie---------------");


    }
}
