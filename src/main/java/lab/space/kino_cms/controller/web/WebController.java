package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

        @GetMapping({"/", ""})
        public String showWebPage() {
            return "redirect:/main";
        }
}
