package lab.space.kino_cms.service;

import lab.space.kino_cms.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    void deleteUserById(Long userId);

    void updateUserById(Long userId, User user);

}
