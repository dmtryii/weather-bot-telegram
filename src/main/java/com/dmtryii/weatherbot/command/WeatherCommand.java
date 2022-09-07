package com.dmtryii.weatherbot.command;

import java.io.IOException;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.dmtryii.weatherbot.service.ApiConnectorService;
import com.dmtryii.weatherbot.service.SendMessageBot;
import com.dmtryii.weatherbot.service.SendWeatherByCityService;

public class WeatherCommand implements Command{
	private final SendMessageBot sendMessageService;
    private final SendWeatherByCityService sendWeatherService;

    public WeatherCommand(SendMessageBot sendMessageService) {
        this.sendMessageService = sendMessageService;
        sendWeatherService = new SendWeatherByCityService(new ApiConnectorService());
    }

    @Override
    public void execute(Update update) {
        String weatherCity = update.getMessage().getText().toLowerCase().split(" ")[1].toLowerCase();
        sendWeatherService.setCity(weatherCity);

        String chatId = update.getMessage().getChatId().toString();
        try {
            sendMessageService.sendMessage(chatId, sendWeatherService.getWeatherInfo());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
