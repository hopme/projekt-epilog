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
import pl.epilog.repositories.FactorRepository;
import pl.epilog.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/factors")
public class FactorController {

    private UserService userService;
    private CategoryRepository categoryRepository;
    private FactorRepository factorRepository;

    public FactorController(UserService userService, CategoryRepository categoryRepository, FactorRepository factorRepository) {
        this.userService = userService;
        this.categoryRepository = categoryRepository;
        this.factorRepository = factorRepository;
    }

    @GetMapping
    public String showFactors(Model model) {
        model.addAttribute("factor", new Factor());
        List<Factor> all = factorRepository.findAll();
        model.addAttribute("factors", all);
        return "show-factors";
    }


    @GetMapping("/add-factor")
    public String addFactor(Model model) {
        model.addAttribute("factorData", new FactorDTO());
        List<Category> all = categoryRepository.findAll();
        model.addAttribute("categories", all);
        return "add-factor";
    }

    @PostMapping("/add-factor")
    public String processAddFactor(@ModelAttribute("factorData") @Valid FactorDTO factorData, BindingResult result) {

        if (result.hasErrors()) {
            return "add-factor";
        }

        userService.addFactor(factorData);
        return "redirect:/factors";
    }




}

