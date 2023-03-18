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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;
    private final CityService cityService;
    private final String username = "antariuzz@gmail.com";

    @Override
    public List<User> getAllUsers() {
        log.info("---------------Get All Users---------------");
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public User getUserById(Long userId) {
        log.info("---------------Get User By ID " + userId + "---------------");
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User Not Found By ID " + userId));
    }

    @Override
    public void deleteUserById(Long userId) {
        log.info("---------------Delete User By ID " + userId + "---------------");
        userRepository.deleteById(userId);
        log.info("---------------Success Delete User By ID " + userId + "---------------");
    }

    @Override
    public void updateUserById(Long userId, User requestedUser) {
        log.info("---------------Update By ID " + requestedUser + "---------------");
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
        log.info("---------------Success Update User By ID " + userId + "---------------");
    }

    @Override
    public void sendMessage(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format("Hello, %s! \n", user.getFirstname());

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(username);
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Письмо");
            mailMessage.setText(message);

            mailSender.send(mailMessage);
        }
    }

}
