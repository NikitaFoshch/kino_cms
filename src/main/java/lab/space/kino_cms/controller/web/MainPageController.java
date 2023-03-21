package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/",""})
@RequiredArgsConstructor
public class MainPageController {
    private final NavbarService navBarService;
    @GetMapping
    public String showMainPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/main-page/main-page";
    }
}
