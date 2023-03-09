package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.TopBannerBlocks;
import lab.space.kino_cms.service.TopBannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/banners")
public class BannersController {
    TopBannerService topBannerService;
    @GetMapping({"/",""})
    public String showBannersPage(){
        return "/admin-panel/pages/banners/banners";
    }
    @GetMapping("add-banner")
    public String addBanner(){
        TopBannerBlocks topBannerBlocks = new TopBannerBlocks();
        topBannerService.addBanner(topBannerBlocks);
        return "redirect:/admin/banners";
    }
}
