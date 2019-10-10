package pl.epilog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.epilog.dto.LoginFormDTO;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String prepareHomePage(Model model) {
        model.addAttribute("data", new LoginFormDTO());
        return "index";
    }


}
