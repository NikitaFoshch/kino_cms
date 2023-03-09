package lab.space.kino_cms.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lab.space.kino_cms.model.City;
import lab.space.kino_cms.model.User;
import lab.space.kino_cms.repository.UserRepository;
import lab.space.kino_cms.service.CityService;
import lab.space.kino_cms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CityService cityService;

    @Override
    public List<User> getAllUsers() {
        log.info("---------------Get All Users---------------");
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public User getUserById(Long userId) {
        log.info("---------------Get User ID " + userId + "---------------");
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found" + userId));
    }

    @Override
    public void deleteUserById(Long userId) {
        log.info("---------------Delete User ID " + userId + "---------------");
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUserById(Long userId, User requestedUser) {
        log.info("---------------Update " + requestedUser + "---------------");
        User user = getUserById(userId);
        City city = cityService.getCityById(requestedUser.getCity().getId());
        user.setFirstname(requestedUser.getFirstname());
        user.setLastname(requestedUser.getLastname());
        user.setUsername(requestedUser.getUsername());
        user.setEmail(requestedUser.getEmail());
        user.setAddress(requestedUser.getAddress());
        user.setPassword(requestedUser.getPassword());
        user.setCardNumber(requestedUser.getCardNumber());
        user.setGender(requestedUser.getGender());
        user.setLanguage(requestedUser.getLanguage());
        user.setPhone(requestedUser.getPhone());
        user.setBirthday(requestedUser.getBirthday());
        user.setCity(city);

        userRepository.save(user);
    }

}
