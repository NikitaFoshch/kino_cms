package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.repository.CinemaRepository;
import lab.space.kino_cms.service.CinemaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;


    @Override
    public Cinema getCinemaById(Long cinemaId) {
        log.info("---------------Get Cinema By ID " + cinemaId + "---------------");
        return cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new EntityNotFoundException("Cinema Not found By ID " + cinemaId));
    }

    @Override
    public void updateCinemaById(Long cinemaId, Cinema requestedCinema) {

    }
}
