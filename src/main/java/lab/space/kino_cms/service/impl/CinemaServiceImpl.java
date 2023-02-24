package lab.space.kino_cms.service.impl;

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

}
