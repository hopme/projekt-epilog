package pl.epilog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.epilog.dto.FactorDTO;
import pl.epilog.model.Category;
import pl.epilog.model.Factor;
import pl.epilog.repositories.CategoryRepository;
import pl.epilog.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/factors")
public class FactorController {

    private UserService userService;
    private CategoryRepository categoryRepository;

    public FactorController(UserService userService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String showFactors(Model model) {
        model.addAttribute("factor", new Factor());
        List<Category> all = categoryRepository.findAll();
        System.out.println(all.size()+"sasadas");
        model.addAttribute("categories", all);
        return "add-factor";
    }


    @PostMapping
    public String processAddFactor(@ModelAttribute("factorData") @Valid FactorDTO factorData, BindingResult result) {
        if (result.hasErrors()) {
            return "add-factor";
        }

        userService.addFactor(factorData);
        return "redirect:/";
    }




}

