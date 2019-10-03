package pl.epilog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.epilog.dto.DayLogDTO;
import pl.epilog.model.Category;
import pl.epilog.model.DayLog;
import pl.epilog.model.Factor;
import pl.epilog.repositories.CategoryRepository;
import pl.epilog.repositories.DayLogRepository;
import pl.epilog.repositories.FactorRepository;
import pl.epilog.services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/daylog")
public class DayLogController {

    DayLogRepository dayLogRepository;
    FactorRepository factorRepository;
    UserService userService;
    CategoryRepository categoryRepository;

    public DayLogController(DayLogRepository dayLogRepository, FactorRepository factorRepository, UserService userService, CategoryRepository categoryRepository) {
        this.dayLogRepository = dayLogRepository;
        this.factorRepository = factorRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String prepareAllLogs(Model model) {
        model.addAttribute("daylog", new DayLog());
        List<DayLog> all = dayLogRepository.findAll();
        model.addAttribute("daylogs", all);
        return "show-logs";
    }

    @GetMapping("/add-log")
    public String prepareAddLog(Model model) {
        model.addAttribute("dayLogData", new DayLogDTO());
        List<Factor> all = factorRepository.findAll();
        model.addAttribute("factors", all);
//        List<Factor> food = factorRepository.findAllByCategoryName("jedzenie");
//        model.addAttribute("foodFactors", food);
//        List<Factor> alcohol = factorRepository.findAllByCategoryName("alkohol");
//        model.addAttribute("alcoFactors", alcohol);
//        List<Factor> tabaco = factorRepository.findAllByCategoryName("tytoń");
//        model.addAttribute("tabacoFactors", tabaco);
//        List<Factor> stress = factorRepository.findAllByCategoryName("stres");
//        model.addAttribute("stresFactors", stress);
        return "add-log";
    }

    @PostMapping("/add-log")
    public String processAddLog(@ModelAttribute("dayLogData") @Valid DayLogDTO dayLogData, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            System.out.println("-------");
            System.out.println(dayLogData.toString());
            System.out.println(result.getAllErrors());
            System.out.println("--------");
            System.out.println(dayLogData.getFactors());
            System.out.println("-------");
            return "add-log";
        }

        System.out.println("DODAJE DO BAZY!");
        System.out.println(dayLogData.toString());
        userService.addDayLog(principal.getName(), dayLogData);
        return "redirect:/";
    }

}
