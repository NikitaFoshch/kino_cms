package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pages")
public class PagesController {
    @GetMapping({"/",""})
    public String showPages(){
        return "/admin-panel/pages/pages/pages";
    }
}
