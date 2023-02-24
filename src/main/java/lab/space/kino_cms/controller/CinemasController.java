package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cinemas")
public class CinemasController {
    @GetMapping({"/",""})
    public String showCinemasPage(){
        return "pages/cinemas/cinemas";
    }

    @GetMapping("cinema-edit")
    public String showCinemaEditPage(){
        return "pages/cinemas/cinema-cart";
    }

    @GetMapping("hall-save")
    public String showHallSavePage(){
        return "pages/cinemas/hall-cart";
    }
}
