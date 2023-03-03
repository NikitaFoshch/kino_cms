package lab.space.kino_cms.controller.admin_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/banners")
public class BannersController {
    @GetMapping({"/",""})
    public String showBannersPage(){
        return "/admin-panel/pages/banners/banners";
    }
}
