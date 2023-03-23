package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.model.Promotions;
import lab.space.kino_cms.service.NavbarService;
import lab.space.kino_cms.service.PromotionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("promotions")
@RequiredArgsConstructor
public class PromotionsController {
    private final PromotionsService promotionsService;
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showPromotionsPage(Model model){
        navBarService.addNavbarModel(model);
        List<Promotions> promotionsList = promotionsService.getPromotionsByOrderByPublicatedAtDesc();
        model.addAttribute("promotionsList", promotionsList);
        return "/web/pages/promotions/promotions";
    }
    @GetMapping("promotions-cart/{id}")
    public String showPromotionsCartPage(@PathVariable("id") Long promotionsPageId,
                                         Model model){
        navBarService.addNavbarModel(model);
        Promotions promotions = promotionsService.getPromotionsById(promotionsPageId);
        model.addAttribute("promotions", promotions);
        return "/web/pages/promotions/promotions-cart";
    }
    @GetMapping("promotions-page/{id}")
    public String showPromotionsPage(@PathVariable("id") Long promotionsPageId,
                               Model model){
        navBarService.addNavbarModel(model);
        Promotions promotions = promotionsService.getPromotionsById(promotionsPageId);
        model.addAttribute("promotions", promotions);
        return "/web/pages/promotions/promotions-page";
    }
}
