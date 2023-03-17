package lab.space.kino_cms.service.impl;

import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.model.News;
import lab.space.kino_cms.model.Promotions;
import lab.space.kino_cms.model.User;
import lab.space.kino_cms.repository.CinemaRepository;
import lab.space.kino_cms.repository.NewsRepository;
import lab.space.kino_cms.repository.PromotionsRepository;
import lab.space.kino_cms.repository.UserRepository;
import lab.space.kino_cms.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsServiceImpl  implements StatisticsService {
    private final CinemaRepository cinemaRepository;
    private final NewsRepository newsRepository;
    private final PromotionsRepository promotionsRepository;
    private final UserRepository userRepository;
    @Override
    public List<Cinema> getAllCinemas() {
        log.info("---------------Get All Cinemas---------------");
        return cinemaRepository.findAll();
    }
    @Override
    public List<News> getAllNews() {
        log.info("---------------Get All News---------------");
        return newsRepository.findAll();
    }
    @Override
    public List<Promotions> getAllPromotions() {
        log.info("---------------Get All Promotions---------------");
        return promotionsRepository.findAll();
    }

    @Override
    public List<User> getAllUsers() {
        log.info("---------------Get All Users---------------");
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllFemaleUsers() {
        log.info("---------------Get All Female Users---------------");
        return userRepository.findAllFemaleUsers();
    }

    @Override
    public List<User> getAllMaleUsers() {
        log.info("---------------Get All Male Users---------------");
        return userRepository.findAllMaleUsers();
    }
}
