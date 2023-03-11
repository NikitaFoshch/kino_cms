package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.CinemaInfo;
import lab.space.kino_cms.model.CommonPage;
import lab.space.kino_cms.model.ContactsPage;
import lab.space.kino_cms.model.MainPage;
import lab.space.kino_cms.service.CinemaInfoService;
import lab.space.kino_cms.service.CommonPageService;
import lab.space.kino_cms.service.ContactsPageService;
import lab.space.kino_cms.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("admin/pages")
@RequiredArgsConstructor
public class PagesController {

    private final MainPageService mainPageService;
    private final CommonPageService commonPageService;
    private final CinemaInfoService cinemaInfoService;
    private final ContactsPageService contactsPageService;

    @GetMapping({"/", ""})
    public String showPages(Model model) {
        MainPage mainPage = mainPageService.getMainePage();
        List<CommonPage> defaultCommonPages = commonPageService.getAllCommonPageByDefaultTrueByOrderByIdAsc();
        ContactsPage contactsPage = contactsPageService.getContactsPage();
        List<CommonPage> commonPages = commonPageService.getAllCommonPageByDefaultFalseByOrderByIdAsc();
        model.addAttribute("mainPage", mainPage);
        model.addAttribute("defaultCommonPages", defaultCommonPages);
        model.addAttribute("contactsPage", contactsPage);
        model.addAttribute("commonPages", commonPages);
        return "/admin-panel/pages/pages/pages";
    }

    @GetMapping("main-page-edit")
    public String showEditMainPage(Model model) {
        MainPage mainPage = mainPageService.getMainePage();
        model.addAttribute("mainPage", mainPage);
        return "/admin-panel/pages/pages/main-page-edit";
    }

    @PostMapping("main-page-update")
    public String updateMainPage(@ModelAttribute MainPage mainPage) {
        mainPageService.updateMainePage(mainPage);
        return "redirect:/admin/pages/main-page-edit";
    }

    @GetMapping("common-page-edit/{id}")
    public String showEditAboutCinemaPage(@PathVariable("id") Long commonPageId,
                                      Model model) {
        CommonPage commonPage = commonPageService.getCommonPageById(commonPageId);
        model.addAttribute("commonPage", commonPage);
        return "/admin-panel/pages/pages/common-page";
    }

    @PostMapping("common-page-update/{id}")
    public String updateCommonPage(@PathVariable("id") Long commonPageId,
                                   @ModelAttribute CommonPage commonPage,
                                   @RequestPart MultipartFile mainPicture,
                                   @RequestPart(required = false) MultipartFile galleryPicture1,
                                   @RequestPart(required = false) MultipartFile galleryPicture2,
                                   @RequestPart(required = false) MultipartFile galleryPicture3,
                                   @RequestPart(required = false) MultipartFile galleryPicture4,
                                   @RequestPart(required = false) MultipartFile galleryPicture5) {
        commonPageService.updateCommonPageById(commonPageId, commonPage,
                mainPicture, galleryPicture1,
                galleryPicture2, galleryPicture3,
                galleryPicture4, galleryPicture5);
        return "redirect:/admin/pages/common-page-edit/" + commonPageId;
    }

    @GetMapping("common-page-add")
    public String addCommonPage(Model model) {
        model.addAttribute("commonPage", new CommonPage());
        return "/admin-panel/pages/pages/common-page";
    }

    @PostMapping("common-page-save")
    public String saveCommonPage(@ModelAttribute CommonPage commonPage,
                                 @RequestPart MultipartFile mainPicture,
                                 @RequestPart(required = false) MultipartFile galleryPicture1,
                                 @RequestPart(required = false) MultipartFile galleryPicture2,
                                 @RequestPart(required = false) MultipartFile galleryPicture3,
                                 @RequestPart(required = false) MultipartFile galleryPicture4,
                                 @RequestPart(required = false) MultipartFile galleryPicture5) {
        if (commonPage.getId() == null) {
            commonPageService.saveCommonPage(commonPage, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        } else {
            commonPageService.updateCommonPageById(commonPage.getId(), commonPage, mainPicture,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }
        return "redirect:/admin/pages";
    }

    @GetMapping("contacts-edit")
    public String showEditContactsPage(Model model) {
        List<CinemaInfo> cinemaInfos = cinemaInfoService.getAllCinemaInfosByOrderByDefaultDesc();
        ContactsPage contactsPage = contactsPageService.getContactsPage();
        model.addAttribute("contactsPage", contactsPage);
        return "/admin-panel/pages/pages/contacts";
    }

    @GetMapping("cinema-info-delete/{id}")
    public String deleteCinemaInfoById(@PathVariable("id") Long cinemaInfoId) {
        cinemaInfoService.deleteCinemaInfoById(cinemaInfoId);
        return "redirect:/admin/pages/contacts-edit";
    }

    @PostMapping("contacts-page-update")
    public String updateCinemaInfo(@ModelAttribute ContactsPage contactsPage) {
        contactsPageService.updateContactsPage(contactsPage);
        return "redirect:/admin/pages/contacts-edit";
    }

    @GetMapping("cinema-info-page-add")
    public String addCinemaInfoPage() {
        cinemaInfoService.addNewCinemaInfoPage();
        return "redirect:/admin/pages/contacts-edit";
    }

}
