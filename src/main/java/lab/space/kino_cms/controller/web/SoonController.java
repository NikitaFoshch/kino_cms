package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("coming-soon")
@RequiredArgsConstructor
public class SoonController {
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showSoonPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/soon/soon";
    }
}
