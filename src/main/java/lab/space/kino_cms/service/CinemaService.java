package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Cinema;

import java.util.List;

public interface CinemaService {
    List<Cinema> getAllCinemasByName(String name);
}
