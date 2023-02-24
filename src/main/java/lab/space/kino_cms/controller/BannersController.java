package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("banners")
public class BannersController {
    @GetMapping({"/",""})
    public String showBannersPage(){
        return "pages/banners/banners";
    }
}
