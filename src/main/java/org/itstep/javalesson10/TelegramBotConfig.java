package org.itstep.javalesson10;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TelegramBotConfig {
    @Value("${telegram.bot.key}")
    private String key;
}
