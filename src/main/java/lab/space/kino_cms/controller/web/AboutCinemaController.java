package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("about-cinema")
public class AboutCinemaController {
    @GetMapping({"/", ""})
    public String showAboutCinemaPage(){
        return "/web/pages/about-cinema/about-cinema";
    }
    @GetMapping("news")
    public String showNewsPage(){
        return "/web/pages/about-cinema/news";
    }
    @GetMapping("cafe-bar")
    public String showCafeBarPage(){
        return "/web/pages/about-cinema/cafe-bar";
    }
    @GetMapping("vip-hall")
    public String showVipHallPage(){
        return "/web/pages/about-cinema/vip-hall";
    }
    @GetMapping("children-room")
    public String showChildrenRoomPage(){
        return "/web/pages/about-cinema/children-room";
    }
    @GetMapping("advertising")
    public String showAdvertisingPage(){
        return "/web/pages/about-cinema/advertising";
    }
    @GetMapping("mobile-app")
    public String showMobileAppPage(){
        return "/web/pages/about-cinema/mobile-app";
    }
    @GetMapping("contacts")
    public String showContactsPage(){
        return "/web/pages/about-cinema/contacts";
    }


}
