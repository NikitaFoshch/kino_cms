package lab.space.kino_cms.controller.admin_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"/", "", "/admin"})
    public String showIndexPage() {
        return "redirect:/admin/statistics";
    }
}
