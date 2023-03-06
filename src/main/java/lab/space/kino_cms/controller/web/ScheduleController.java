package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule")
public class ScheduleController {
    @GetMapping({"/",""})
    public String showSchedulePage(){
        return "/web/pages/schedule/schedule";
    }
    @GetMapping("ticket-booking")
    public String showTicketBookingPage(){
        return "/web/pages/schedule/ticket-booking";
    }
}
