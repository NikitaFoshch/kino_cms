package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.City;
import lab.space.kino_cms.model.User;
import lab.space.kino_cms.service.CityService;
import lab.space.kino_cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CityService cityService;

    @GetMapping({"/", ""})
    public String showUsersPage(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "/admin-panel/pages/users/users";
    }

    @GetMapping("user-edit/{id}")
    public String showUserEditPage(@PathVariable("id") Long userId,
                                   Model model) {
        User userById = userService.getUserById(userId);
        List<City> cities = cityService.getAllCities();
        model.addAttribute("user", userById);
        model.addAttribute("cities", cities);
        return "/admin-panel/pages/users/user";
    }

    @PostMapping("user-update/{id}")
    public String updateUser(@PathVariable("id") Long userId,
                             @ModelAttribute User user) {
        userService.updateUserById(userId, user);
        return "redirect:/admin/users/user-edit/" + userId;
    }

    @GetMapping("user-delete/{userId}")
    public String deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return "redirect:/admin/users";
    }

}
