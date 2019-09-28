package pl.epilog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logs")
public class DayLogController {

    @GetMapping
    public String showLogs() {

        return "add-log";
    }

}
