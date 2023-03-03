package lab.space.kino_cms.controller.admin_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping({"/admin", "/admin/"})
    public String showAdminPage() {
        return "redirect:/admin/statistics";
    }
}
