package lab.space.kino_cms.service.impl;

import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.repository.CinemaRepository;
import lab.space.kino_cms.service.CinemaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAllCinemasByName(String name) {
        return cinemaRepository.findAllByName(name);
    }
}
