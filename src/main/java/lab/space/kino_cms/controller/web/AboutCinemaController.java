package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("about-cinema")
public class AboutCinemaController {
    @GetMapping({"/",""})
    public String showAboutCinemaPage(){
        return "/web/pages/about-cinema/about-cinema";
    }
}
