package org.itstep.javalesson10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Random;

@Controller
public class HomeController {

    Random random = new Random();

    @GetMapping
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("list", new String[]{"one", "two", "three"});
        if(random.nextBoolean()) {
            model.addAttribute("error", "Some error");
        }

        return "index";
    }

}
