package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("coming-soon")
public class SoonController {
    @GetMapping({"/",""})
    public String showSoonPage(){
        return "/web/pages/soon/soon";
    }
}
