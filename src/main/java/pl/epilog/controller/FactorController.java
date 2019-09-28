package pl.epilog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.epilog.model.Factor;

@Controller
@RequestMapping("/factors")
public class FactorController {

    @GetMapping
    public String showFactors() {

        return "add-factor";
    }

    @GetMapping("/add-factor")
    public String prepareAddFactor(Model model){
        model.addAttribute("factor", new Factor());
        model.addAttribute("categories", )
        return "add-factor";
    }

}

