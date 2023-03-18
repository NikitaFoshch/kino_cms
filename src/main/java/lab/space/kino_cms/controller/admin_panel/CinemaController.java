package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.Cinema;
import lab.space.kino_cms.model.Hall;
import lab.space.kino_cms.service.CinemaService;
import lab.space.kino_cms.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("admin/cinemas")
@RequiredArgsConstructor
public class CinemaController {
    private final CinemaService cinemaService;
    private final HallService hallService;

    @GetMapping({"/", ""})
    public String showCinemasPage(Model model) {
        List<Cinema> cinemas = cinemaService.getAllCinema();
        model.addAttribute("cinemas", cinemas);
        return "/admin-panel/pages/cinemas/cinemas";
    }

    @GetMapping("cinema-edit/{id}")
    public String showCinemaEditPage(@PathVariable("id") Long cinemaId,
                                     Model model) {
        Cinema cinema = cinemaService.getCinemaById(cinemaId);
        model.addAttribute("cinema", cinema);
        model.addAttribute("hallsByCinema", hallService.getAllHallByCinemaByOrderByCreatedAtAsc(cinema));
        return "/admin-panel/pages/cinemas/cinema-cart";
    }

    @GetMapping("cinema-add")
    public String addCinema(Model model) {
        model.addAttribute("cinema",cinemaService.addCinema());
        return "/admin-panel/pages/cinemas/cinema-cart";
    }

    @PostMapping("cinema-update/{id}")
    public String updateCinema(@PathVariable("id") Long cinemaId,
                             @ModelAttribute Cinema cinema,
                             @RequestPart MultipartFile logo,
                             @RequestPart(required = false) MultipartFile topBanner,
                             @RequestPart(required = false) MultipartFile galleryPicture1,
                             @RequestPart(required = false) MultipartFile galleryPicture2,
                             @RequestPart(required = false) MultipartFile galleryPicture3,
                             @RequestPart(required = false) MultipartFile galleryPicture4,
                             @RequestPart(required = false) MultipartFile galleryPicture5) {
        cinemaService.updateCinemaById(cinemaId, cinema, logo,
                topBanner, galleryPicture1,
                galleryPicture2, galleryPicture3,
                galleryPicture4, galleryPicture5);
        return "redirect:/admin/cinemas/cinema-edit/" + cinemaId;
    }

    @PostMapping("cinema-save")
    public String saveCinema(@ModelAttribute Cinema cinema,
                           @RequestPart MultipartFile logoImage,
                           @RequestPart(required = false) MultipartFile topBannerImage,
                           @RequestPart(required = false) MultipartFile galleryPicture1,
                           @RequestPart(required = false) MultipartFile galleryPicture2,
                           @RequestPart(required = false) MultipartFile galleryPicture3,
                           @RequestPart(required = false) MultipartFile galleryPicture4,
                           @RequestPart(required = false) MultipartFile galleryPicture5) {
        if (cinema.getId()==null){
            cinemaService.saveCinema(cinema, logoImage, topBannerImage,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }else {
            cinemaService.updateCinemaById(cinema.getId(), cinema,
                    logoImage, topBannerImage, galleryPicture1,
                    galleryPicture2, galleryPicture3,
                    galleryPicture4, galleryPicture5);
        }
        return "redirect:/admin/cinemas";
    }

    @GetMapping("cinema-delete/{id}")
    public String deleteCinemaById(@PathVariable("id") Long cinemaId) {
        cinemaService.deleteCinemaById(cinemaId);
        return "redirect:/admin/cinemas";
    }

    @GetMapping("{cinemaId}/hall-edit/{id}")
    public String showHallSavePage(@PathVariable("cinemaId") Long cinemaId,
            @PathVariable("id") Long hallId,
                                   Model model) {
        Hall hall = hallService.getHallById(hallId);
        model.addAttribute("hall", hall);
        model.addAttribute("cinemaId", cinemaId);
        return "/admin-panel/pages/cinemas/hall-cart";
    }

    @GetMapping("{id}/hall/add")
    public String addHall(@PathVariable("id") Long cinemaId,
            Model model) {
        model.addAttribute("hall", hallService.addHall());
        model.addAttribute("cinemaId", cinemaId);
        return "/admin-panel/pages/cinemas/hall-cart";
    }

    @PostMapping("hall-update/{id}")
    public String updateHall(@PathVariable("id") Long hallId,
                               @ModelAttribute Hall hall,
                               @RequestPart MultipartFile schema,
                               @RequestPart(required = false) MultipartFile topBanner,
                               @RequestPart(required = false) MultipartFile galleryPicture1,
                               @RequestPart(required = false) MultipartFile galleryPicture2,
                               @RequestPart(required = false) MultipartFile galleryPicture3,
                               @RequestPart(required = false) MultipartFile galleryPicture4,
                               @RequestPart(required = false) MultipartFile galleryPicture5) {
        hallService.updateHallById(hallId, hall, schema,
                topBanner, galleryPicture1,
                galleryPicture2, galleryPicture3,
                galleryPicture4, galleryPicture5);
        return "redirect:/admin/cinemas/hall-edit/" + hallId;
    }

    @PostMapping("hall-save/{id}")
    public String saveHall(@PathVariable("id") Long cinemaId,
                           @ModelAttribute Hall hall,
                           @RequestPart MultipartFile schemaImage,
                           @RequestPart(required = false) MultipartFile topBannerImage,
                           @RequestPart(required = false) MultipartFile galleryPicture1,
                           @RequestPart(required = false) MultipartFile galleryPicture2,
                           @RequestPart(required = false) MultipartFile galleryPicture3,
                           @RequestPart(required = false) MultipartFile galleryPicture4,
                           @RequestPart(required = false) MultipartFile galleryPicture5) {
        if (hall.getId()==null){
            hallService.saveHall(hall, schemaImage, topBannerImage,
                    galleryPicture1, galleryPicture2,
                    galleryPicture3, galleryPicture4,
                    galleryPicture5);
        }else {
            hallService.updateHallById(hall.getId(), hall,
                    schemaImage, topBannerImage, galleryPicture1,
                    galleryPicture2, galleryPicture3,
                    galleryPicture4, galleryPicture5);
        }
        return "redirect:/admin/cinemas/cinema-edit/" + cinemaId;
    }

    @GetMapping("hall-delete/{id}")
    public String deleteHallById(@PathVariable("id") Long hallId) {
        hallService.deleteHallById(hallId);
        return "redirect:/admin/cinemas";
    }
}
