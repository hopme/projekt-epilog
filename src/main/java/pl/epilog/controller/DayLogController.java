package pl.epilog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.epilog.dto.DayLogDTO;
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

    private DayLogRepository dayLogRepository;
    private FactorRepository factorRepository;
    private UserService userService;

    public DayLogController(DayLogRepository dayLogRepository, FactorRepository factorRepository, UserService userService) {
        this.dayLogRepository = dayLogRepository;
        this.factorRepository = factorRepository;
        this.userService = userService;
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
        List<Factor> food = factorRepository.findAllByCategoryName("jedzenie");
        model.addAttribute("foodFactors", food);
        List<Factor> alcohol = factorRepository.findAllByCategoryName("alkohol");
        model.addAttribute("alcoFactors", alcohol);
        List<Factor> tabaco = factorRepository.findAllByCategoryName("tytoń");
        model.addAttribute("tabacoFactors", tabaco);
        List<Factor> stress = factorRepository.findAllByCategoryName("stres");
        model.addAttribute("stresFactors", stress);
        return "add-log";
    }

//EDYCJA - zrob to jako tabelka z checkboxami - ale na koncu
//    @GetMapping("/edit-log/{logId}")
//    public String prepareEditLogPage(@PathVariable Long logId, Model model) {
//        DayLog dayLog = dayLogRepository.findOne(logId);
//        if (dayLog == null) {
//            return "redirect:/daylogs";
//        }
//        model.addAttribute("editedLogData", dayLog);
//        return "edit-log";
//    }


//    @GetMapping("/remove-book/{bookId}")
//    public String prepareRemoveBookPage(@PathVariable Long bookId, Model model) {
//        model.addAttribute("removeBook", bookDao.findById(bookId));
//        return "remove-book";
//    }


    @PostMapping("/add-log")
    public String processAddLog(@ModelAttribute("dayLogData") @Valid DayLogDTO dayLogData, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "add-log";
        }
        userService.addDayLog(principal.getName(), dayLogData);
        return "redirect:/";
    }

}
