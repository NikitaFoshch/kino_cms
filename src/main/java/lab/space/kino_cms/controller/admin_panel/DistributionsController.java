package lab.space.kino_cms.controller.admin_panel;

import jakarta.mail.MessagingException;
import lab.space.kino_cms.model.EmailDistribution;
import lab.space.kino_cms.model.SmsDistribution;
import lab.space.kino_cms.model.User;
import lab.space.kino_cms.service.EmailDistributionService;
import lab.space.kino_cms.service.SmsDistributionService;
import lab.space.kino_cms.service.TemplateService;
import lab.space.kino_cms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("admin/distributions")
@RequiredArgsConstructor
public class DistributionsController {
    private final UserService userService;
    private final EmailDistributionService emailDistributionService;
    private final TemplateService templateService;
    private final SmsDistributionService smsDistributionService;
    @GetMapping({"/",""})
    public String showDistributionPage(Model model){
        EmailDistribution emailDistribution = emailDistributionService.getEmailDistribution();
        SmsDistribution smsDistribution = smsDistributionService.getSmsDistribution();
        model.addAttribute("emailDistribution",emailDistribution);
        model.addAttribute("smsDistribution",smsDistribution);
        model.addAttribute("count",smsDistribution.getText().length());
        return "/admin-panel/pages/distributions/distributions";
    }

    @GetMapping("pick-users")
    public String showUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "/admin-panel/pages/distributions/pick-users";
    }
    @PostMapping("users-pick-update/{userList}")
    public String updateUsersMailSender(@PathVariable List<User> userList){
        System.out.println(userList);
        return "redirect:/admin/distributions";
    }

    @PostMapping("email-send")
    public String emailSend(@ModelAttribute EmailDistribution emailDistribution) throws MessagingException {
        emailDistributionService.updateEmailDistribution(emailDistribution);
        emailDistributionService.sendMessage();
        return "redirect:/admin/distributions";
    }

    @PostMapping("template-update")
    public String templateUpdate(@RequestPart MultipartFile htmlDocument){
        templateService.saveTemplate(htmlDocument);
        return "redirect:/admin/distributions";
    }

    @GetMapping("template-delete/{templateId}")
    public String deleteTemplateById(@PathVariable("templateId") Long templateId) {
        templateService.deleteTemplateById(templateId);
        return "redirect:/admin/distributions";
    }

    @PostMapping("sms-send")
    public String smsSend(@ModelAttribute SmsDistribution smsDistribution){
        smsDistributionService.updateSmsDistribution(smsDistribution);
        return "redirect:/admin/distributions";
    }
}
