package lab.space.kino_cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("statistics")
public class StatisticsController {
    @GetMapping({"/", ""})
    public String showStatisticsPage() {
        return "/admin-panel/pages/statistics/statistics";
    }
}
