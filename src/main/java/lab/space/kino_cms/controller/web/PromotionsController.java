package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("promotions")
@RequiredArgsConstructor
public class PromotionsController {
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showPromotionsPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/promotions/promotions";
    }
    @GetMapping("promotions-cart")
    public String showPromotionsCartPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/promotions/promotions-cart";
    }
}
