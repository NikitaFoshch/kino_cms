package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.MainPage;
import lab.space.kino_cms.service.MainPageService;
import lab.space.kino_cms.service.SeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/pages")
@RequiredArgsConstructor
public class PagesController {

    private final MainPageService mainPageService;
    private final SeoService seoService;

    @GetMapping({"/",""})
    public String showPages(){
        return "/admin-panel/pages/pages/pages";
    }

    @GetMapping("main-page-edit")
    public String editMainPage(Model model){
        MainPage mainPage = mainPageService.getMainePage();
        model.addAttribute("mainPage", mainPage);
        return "/admin-panel/pages/pages/main-page-edit";
    }

    @GetMapping("common-page-edit")
    public String editAboutCinemaPage(){
        return "/admin-panel/pages/pages/common-page";
    }

    @GetMapping("contacts-edit")
    public String editContactsPage(){
        return "/admin-panel/pages/pages/contacts";
    }

    @PostMapping("main-page-update")
    public String updateUser(@ModelAttribute MainPage mainPage) {
        mainPageService.updateMainePage(mainPage);
        return "redirect:/admin/pages/main-page-edit";
    }

}
