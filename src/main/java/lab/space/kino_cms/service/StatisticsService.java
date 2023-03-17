package lab.space.kino_cms.service;

import lab.space.kino_cms.model.User;

import java.util.List;

public interface StatisticsService {

    List<User> getAllUsers();
    List<User> getAllFemaleUsers();
    List<User> getAllMaleUsers();

}
