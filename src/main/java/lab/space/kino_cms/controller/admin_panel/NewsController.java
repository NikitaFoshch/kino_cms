package lab.space.kino_cms.controller.admin_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/news")
public class NewsController {
    @GetMapping({"/",""})
    public String showNewsPage(){
        return "/admin-panel/pages/news/news";
    }

    @GetMapping("news-edit")
    public String showNewsEditPage(){
        return "/admin-panel/pages/news/news-page";
    }
}
