package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {

    @GetMapping({"/", ""})
    public String showUsersPage() {
        return "pages/users/users";
    }

    @GetMapping("user-edit")
    public String showUserEditPage() {
        return "pages/users/user";
    }
}
