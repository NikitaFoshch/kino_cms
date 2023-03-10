package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.Promotions;
import lab.space.kino_cms.service.PromotionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("admin/promotions")
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionsService promotionsService;
    @GetMapping({"/", ""})
    public String showPromotionsPage(Model model) {
        List<Promotions> promotionsList = promotionsService.getAllPromotions();
        model.addAttribute("promotionsList", promotionsList);
        return "/admin-panel/pages/promotions/promotions";
    }

    @GetMapping("edit/{id}")
    public String showPromotionsEditPage(@PathVariable("id") Long promotionsId,
                                         Model model) {
        Promotions promotions = promotionsService.getPromotionsById(promotionsId);
        model.addAttribute("promotions", promotions);
        return "/admin-panel/pages/promotions/promotions-page";
    }

    @PostMapping("update/{id}")
    public String updatePromotions(@PathVariable("id") Long promotionsId,
                             @ModelAttribute Promotions promotions,
                             @RequestPart MultipartFile mainPicture,
                             @RequestPart(required = false) MultipartFile galleryPicture1,
                             @RequestPart(required = false) MultipartFile galleryPicture2,
                             @RequestPart(required = false) MultipartFile galleryPicture3,
                             @RequestPart(required = false) MultipartFile galleryPicture4,
                             @RequestPart(required = false) MultipartFile galleryPicture5) {
        promotionsService.updatePromotionsById(promotionsId, promotions,
                mainPicture, galleryPicture1,
                galleryPicture2, galleryPicture3,
                galleryPicture4, galleryPicture5);
        return "redirect:/admin/promotions/edit/" + promotionsId;
    }

    @GetMapping("add")
    public String addPromotions(Model model) {
        model.addAttribute("promotions", new Promotions());
        return "/admin-panel/pages/promotions/promotions-page";
    }
    @PostMapping("save")
    public String savePromotions(@ModelAttribute Promotions promotions,
                           @RequestPart MultipartFile mainPicture,
                           @RequestPart(required = false) MultipartFile galleryPicture1,
                           @RequestPart(required = false) MultipartFile galleryPicture2,
                           @RequestPart(required = false) MultipartFile galleryPicture3,
                           @RequestPart(required = false) MultipartFile galleryPicture4,
                           @RequestPart(required = false) MultipartFile galleryPicture5) {
        if (promotions.getId()==null){
            promotionsService.savePromotions(promotions, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }else {
            promotionsService.updatePromotionsById(promotions.getId(), promotions, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }
        return "redirect:/admin/promotions";
    }

    @GetMapping("delete/{id}")
    public String deletePromotionsById(@PathVariable("id") Long promotionsId) {
        promotionsService.deletePromotionsById(promotionsId);
        return "redirect:/admin/promotions";
    }
}
