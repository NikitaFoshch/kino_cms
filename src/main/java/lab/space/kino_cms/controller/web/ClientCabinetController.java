package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.model.City;
import lab.space.kino_cms.model.User;
import lab.space.kino_cms.service.CityService;
import lab.space.kino_cms.service.NavbarService;
import lab.space.kino_cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("client-cabinet")
@RequiredArgsConstructor
public class ClientCabinetController {
    private final UserService userService;
    private final CityService cityService;
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showClientCabinetPage(Model model){
        navBarService.addNavbarModel(model);
        List<City> cities = cityService.getAllCities();
        model.addAttribute("user", new User());
        model.addAttribute("cities", cities);
        return "web/pages/client-cabinet/client-cabinet";
    }

    @PostMapping("user-save")
    public String updateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/client-cabinet";
    }
}
