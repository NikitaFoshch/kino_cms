package lab.space.kino_cms.service.impl;

import lab.space.kino_cms.model.User;
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
    private final UserRepository userRepository;
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
