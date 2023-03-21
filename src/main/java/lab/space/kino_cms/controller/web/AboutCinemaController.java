package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("about-cinema")
public class AboutCinemaController {
    private final MainPageService mainPageService;
    private final CommonPageService commonPageService;
    private final CinemaInfoService cinemaInfoService;
    private final NavbarService navBarService;
    private final ContactsPageService contactsPageService;
    @GetMapping({"/", ""})
    public String showAboutCinemaPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/about-cinema/about-cinema";
    }
    @GetMapping("common-page")
    public String showAdvertisingPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/about-cinema/common-page";
    }
    @GetMapping("contacts")
    public String showContactsPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/about-cinema/contacts";
    }

    @GetMapping("news")
    public String showNewsPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/about-cinema/news";
    }
}
