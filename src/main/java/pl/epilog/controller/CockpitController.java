package pl.epilog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.epilog.model.*;
import pl.epilog.repositories.CorrelationRepository;
import pl.epilog.repositories.DayLogRepository;
import pl.epilog.repositories.FactorRepository;
import pl.epilog.repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cockpit")
@Transactional
public class CockpitController {

    private DayLogRepository dayLogRepository;
    private FactorRepository factorRepository;
    private UserRepository userRepository;
    private CorrelationRepository correlationRepository;

    public CockpitController(DayLogRepository dayLogRepository, FactorRepository factorRepository, UserRepository userRepository, CorrelationRepository correlationRepository) {
        this.dayLogRepository = dayLogRepository;
        this.factorRepository = factorRepository;
        this.userRepository = userRepository;
        this.correlationRepository = correlationRepository;
    }

    @GetMapping
    public String prepareCockpit(Model model, Principal principal) {
        model.addAttribute("daylog", new DayLog());
        User user = userRepository.getByEmail(principal.getName());
        List<DayLog> allDaylogs = dayLogRepository.findAllByUser(user);
        model.addAttribute("daylogs", allDaylogs);
        model.addAttribute("factor",new Factor());
        List<Factor> allFactors = factorRepository.findAll();
        model.addAttribute("factors", allFactors);
        List<Correlation> allCorrelations = correlationRepository.findAllByUserId(user.getId());
        model.addAttribute("correlations", allCorrelations);
        return "cockpit";
    }


}
