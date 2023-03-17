package lab.space.kino_cms.service;

import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.model.News;
import lab.space.kino_cms.model.Promotions;
import lab.space.kino_cms.model.User;

import java.util.List;

public interface StatisticsService {
    List<Cinema> getAllCinemas();
    List<News> getAllNews();
    List<Promotions> getAllPromotions();
    List<User> getAllUsers();
    List<User> getAllFemaleUsers();
    List<User> getAllMaleUsers();

}
