package lab.space.kino_cms.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("client-cabinet")
public class ClientCabinetController {
    @GetMapping({"/",""})
    public String showClientCabinetPage(){
        return "web/pages/client-cabinet/client-cabinet";
    }
}
