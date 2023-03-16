package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.BackgroundBanner;
import lab.space.kino_cms.model.NewsBanner;
import lab.space.kino_cms.model.TopBanner;
import lab.space.kino_cms.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("admin/banners")
@RequiredArgsConstructor
public class BannersController {
    private final TopBannerService topBannerService;
    private final TopBannerBlocksService topBannerBlocksService;
    private final BackgroundBannerService backgroundBannerService;
    private final NewsBannerService newsBannerService;
    private final NewsBannerBlocksService newsBannerBlocksService;
    @GetMapping({"/",""})
    public String showBannersPage(Model model){
        TopBanner topBanner = topBannerService.getTopBanner();
        BackgroundBanner backgroundBanner = backgroundBannerService.getBackgroundBanner();
        NewsBanner newsBanner = newsBannerService.getNewsBanner();

        model.addAttribute("topBanner", topBanner);
        model.addAttribute("backgroundBanner", backgroundBanner);
        model.addAttribute("newsBanner", newsBanner);
        return "/admin-panel/pages/banners/banners";
    }
    @GetMapping("top-banners-blocks-delete/{id}")
    public String deleteTopBannerBlockById(@PathVariable("id") Long topBannerBlockId) {
        topBannerBlocksService.deleteTopBannerBlockById(topBannerBlockId);
        return "redirect:/admin/banners";
    }

    @PostMapping("top-banner-update")
    public String updateTopBannerBlocks(@ModelAttribute TopBanner topBanner) {
        topBannerService.updateTopBanner(topBanner);
        return "redirect:/admin/banners";
    }

    @GetMapping("top-banners-blocks-add")
    public String addTopBannerBlock() {
        topBannerBlocksService.addNewTopBannerBlock();
        return "redirect:/admin/banners";
    }

    @PostMapping("background-banner-update")
    public String updateBackgroundBanner(@ModelAttribute BackgroundBanner backgroundBanner,
                                         @RequestPart MultipartFile backgroundPicture) {
        backgroundBannerService.updateBackgroundBanner(backgroundBanner,backgroundPicture);
        return "redirect:/admin/banners";
    }

    @GetMapping("news-banners-blocks-delete/{id}")
    public String deleteNewsBannerBlockById(@PathVariable("id") Long newsBannerBlockId) {
        newsBannerBlocksService.deleteNewsBannerBlockById(newsBannerBlockId);
        return "redirect:/admin/banners";
    }

    @PostMapping("news-banner-update")
    public String updateNewsBannerBlocks(@ModelAttribute NewsBanner newsBanner) {
        newsBannerService.updateNewsBanner(newsBanner);
        return "redirect:/admin/banners";
    }

    @GetMapping("news-banners-blocks-add")
    public String addNewsBannerBlock() {
        newsBannerBlocksService.addNewNewsBannerBlock();
        return "redirect:/admin/banners";
    }
}
