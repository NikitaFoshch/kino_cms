package lab.space.kino_cms.controller.web;

import lab.space.kino_cms.service.NavbarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final NavbarService navBarService;
    @GetMapping({"/",""})
    public String showSchedulePage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/schedule/schedule";
    }
    @GetMapping("ticket-booking")
    public String showTicketBookingPage(Model model){
        navBarService.addNavbarModel(model);
        return "/web/pages/schedule/ticket-booking";
    }
}
