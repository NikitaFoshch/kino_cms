package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("distributions")
public class DistributionsController {
    @GetMapping({"/",""})
    public String showDistributionPage(){
        return "/admin-panel/pages/distributions/distributions";
    }

    @GetMapping("pick-users")
    public String showUsers(){
        return "/admin-panel/pages/distributions/pick-users";
    }
}
