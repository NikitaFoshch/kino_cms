package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("promotions")
public class PromotionsController {
    @GetMapping({"/", ""})
    public String showPromotionsPage() {
        return "/admin-panel/pages/promotions/promotions";
    }

    @GetMapping("promotions-edit")
    public String showPromotionsEditPage() {
        return "/admin-panel/pages/promotions/promotions-page";
    }
}
