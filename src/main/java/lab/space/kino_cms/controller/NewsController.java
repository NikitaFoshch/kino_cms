package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("news")
public class NewsController {
    @GetMapping({"/",""})
    public String showNewsPage(){
        return "pages/news/news";
    }

    @GetMapping("news-edit")
    public String showNewsEditPage(){
        return "pages/news/news-page";
    }
}
