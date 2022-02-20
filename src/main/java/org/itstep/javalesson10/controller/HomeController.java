package org.itstep.javalesson10.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itstep.javalesson10.TelegramBotConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    Random random = new Random();

    private final TelegramBotConfig telegramBotConfig;

    @GetMapping
    String index(Model model) {
        log.info("Telegram bot key: {}", telegramBotConfig.getKey());
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("list", new String[]{"one", "two", "three"});
        if(random.nextBoolean()) {
            model.addAttribute("error", "Some error");
        }

        return "index";
    }

}
