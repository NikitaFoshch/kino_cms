package lab.space.kino_cms.controller.admin_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/cinemas")
public class CinemasController {
    @GetMapping({"/",""})
    public String showCinemasPage(){
        return "/admin-panel/pages/cinemas/cinemas";
    }

    @GetMapping("cinema-edit")
    public String showCinemaEditPage(){
        return "/admin-panel/pages/cinemas/cinema-cart";
    }

    @GetMapping("hall-save")
    public String showHallSavePage(){
        return "/admin-panel/pages/cinemas/hall-cart";
    }
}
