package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cinemas")
@RequiredArgsConstructor
public class CinemasController {
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showCinemasPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/cinemas/cinemas";
    }
    @GetMapping("cinema-cart")
    public String showCinemasCartPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/cinemas/cinema-cart";
    }
    @GetMapping("hall-cart")
    public String showHallCartPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/cinemas/hall-cart";
    }
}
