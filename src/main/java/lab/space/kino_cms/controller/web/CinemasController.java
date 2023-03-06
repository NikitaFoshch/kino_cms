package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cinemas")
public class CinemasController {
    @GetMapping({"/",""})
    public String showCinemasPage(){
        return "/web/pages/cinemas/cinemas";
    }
    @GetMapping("cinema-cart")
    public String showCinemasCartPage(){
        return "/web/pages/cinemas/cinema-cart";
    }
    @GetMapping("hall-cart")
    public String showHallCartPage(){
        return "/web/pages/cinemas/hall-cart";
    }
}
