package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.model.CommonPage;
import lab.space.kino_cms.model.ContactsPage;
import lab.space.kino_cms.model.News;
import lab.space.kino_cms.service.CommonPageService;
import lab.space.kino_cms.service.ContactsPageService;
import lab.space.kino_cms.service.NavbarService;
import lab.space.kino_cms.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("about-cinema")
public class AboutCinemaController {
    private final CommonPageService commonPageService;
    private final NavbarService navBarService;
    private final ContactsPageService contactsPageService;
    private final NewsService newsService;
    @GetMapping({"/", ""})
    public String showAboutCinemaPage(){
        return "redirect:/about-cinema/contacts";
    }
    @GetMapping("common-page/{id}")
    public String showCommonPage(@PathVariable("id") Long commonPageId,
                                 Model model){
        navBarService.addNavbarModel(model);
        CommonPage showCommonPage = commonPageService.getCommonPageById(commonPageId);
        model.addAttribute("showCommonPage", showCommonPage);
        return "/web/pages/about-cinema/common-page";
    }
    @GetMapping("contacts")
    public String showContactsPage(Model model){
        navBarService.addNavbarModel(model);
        ContactsPage contactsPage = contactsPageService.getContactsPage();
        model.addAttribute("contactsPage", contactsPage);
        return "/web/pages/about-cinema/contacts";
    }

    @GetMapping("news")
    public String showNewsPagesPage(Model model){
        navBarService.addNavbarModel(model);
        List<News> newsList = newsService.getNewsByOrderByPublicatedAtDesc();
        model.addAttribute("newsList", newsList);
        return "/web/pages/about-cinema/news";
    }

    @GetMapping("news/news-page/{id}")
    public String showNewsPage(@PathVariable("id") Long newsPageId,
                               Model model){
        navBarService.addNavbarModel(model);
        News news = newsService.getNewsById(newsPageId);
        model.addAttribute("news", news);
        return "/web/pages/about-cinema/news-page";
    }
}
