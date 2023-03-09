package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Cinema;

public interface CinemaService {
    Cinema getCinemaById(Long cinemaId);
    void updateCinemaById(Long cinemaId, Cinema requestedCinema);
}
