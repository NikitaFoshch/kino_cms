package lab.space.kino_cms.controller.admin_panel;

import lab.space.kino_cms.model.User;
import lab.space.kino_cms.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;

    @GetMapping({"/", ""})
    public String showStatisticsPage(Model model) {
        List<User> userList = statisticsService.getAllUsers();
        List<User> userFemaleList = statisticsService.getAllFemaleUsers();
        List<User> userMaleList = statisticsService.getAllMaleUsers();
        model.addAttribute("numberOfUsers", userList.size());
        model.addAttribute("numberOfFemaleUsers", userFemaleList.size());
        model.addAttribute("numberOfMaleUsers", userMaleList.size());
        return "/admin-panel/pages/statistics/statistics";
    }
}
