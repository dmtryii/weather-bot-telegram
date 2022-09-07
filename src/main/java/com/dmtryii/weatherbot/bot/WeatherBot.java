package com.dmtryii.weatherbot.bot;

import com.dmtryii.weatherbot.location.WeatherByGeolocation;
import com.dmtryii.weatherbot.service.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.dmtryii.weatherbot.command.CommandContainer;
import com.dmtryii.weatherbot.config.BotConfig;

public class WeatherBot extends TelegramLongPollingBot {
	public static final String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;

    @Override
    public String getBotUsername() {
        return BotConfig.botName;
    }

    @Override
    public String getBotToken() {
        return BotConfig.botToken;
    }

    public WeatherBot(){
        this.commandContainer = new CommandContainer(new SendMessageBotService(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().toLowerCase();
            if(message.startsWith(COMMAND_PREFIX)){
                String commandInd = message.split(" ")[0].toLowerCase();
                commandContainer.getCommand(commandInd).execute(update);
            }
        }

        if(update.hasMessage() && update.getMessage().hasLocation()) {
            WeatherByGeolocation weatherByLocation =
                    new WeatherByGeolocation(new SendMessageBotService(this));
            weatherByLocation.getWeather(update);
        }
    }
}
