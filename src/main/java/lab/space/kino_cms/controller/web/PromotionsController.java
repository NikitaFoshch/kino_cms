package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("promotions")
public class PromotionsController {
    @GetMapping({"/",""})
    public String showPromotionsPage(){
        return "/web/pages/promotions/promotions";
    }
}
