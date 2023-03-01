package lab.space.kino_cms.controller;

import lab.space.kino_cms.model.MainPage;
import lab.space.kino_cms.model.Seo;
import lab.space.kino_cms.service.MainPageService;
import lab.space.kino_cms.service.SeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("pages")
@RequiredArgsConstructor
public class PagesController {

    private final MainPageService mainPageService;
    private final SeoService seoService;

    @GetMapping({"/",""})
    public String showPages(){
        return "/admin-panel/pages/pages/pages";
    }

    @GetMapping("main-page-edit/{id}")
    public String editMainPage(@PathVariable("id") Long mainPageId, Model model){
        MainPage mainPage = mainPageService.getMainePageById(mainPageId);
        Seo seo = seoService.getSEOById(mainPage.getSeo().getId());
        model.addAttribute("mainPage", mainPage);
        model.addAttribute("seo", seo);
        return "/admin-panel/pages/pages/main-page-edit";
    }

    @GetMapping("about-cinema-edit")
    public String editAboutCinemaPage(){
        return "/admin-panel/pages/pages/about-cinema";
    }

    @GetMapping("advertising-edit")
    public String editAdvertisingPage(){
        return "/admin-panel/pages/pages/advertising";
    }

    @GetMapping("cafe-bar-edit")
    public String editCafeBarPage(){
        return "/admin-panel/pages/pages/cafe-bar";
    }

    @GetMapping("contacts-edit")
    public String editContactsPage(){
        return "/admin-panel/pages/pages/contacts";
    }

    @GetMapping("kids-room-edit")
    public String editKidsRoomPage(){
        return "/admin-panel/pages/pages/kids-room";
    }

    @GetMapping("vip-hall-edit")
    public String editVipHallPage(){
        return "/admin-panel/pages/pages/vip-hall";
    }

    @PostMapping("main-page-update/{id}")
    public String updateUser(@PathVariable("id") Long mainPageId,
                             @ModelAttribute MainPage mainPage) {
        mainPageService.updateMainePageById(mainPageId, mainPage);
        return "redirect:/pages/main-page-edit/" + mainPageId;
    }

}
