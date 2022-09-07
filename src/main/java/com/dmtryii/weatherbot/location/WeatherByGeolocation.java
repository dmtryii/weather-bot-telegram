package com.dmtryii.weatherbot.location;

import com.dmtryii.weatherbot.service.ApiConnectorService;
import com.dmtryii.weatherbot.service.SendMessageBot;
import com.dmtryii.weatherbot.service.SendWeatherByGeolocationService;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class WeatherByGeolocation {
    private final SendMessageBot sendMessageService;
    private final SendWeatherByGeolocationService sendWeatherService;

    public WeatherByGeolocation(SendMessageBot sendMessageService) {
        this.sendMessageService = sendMessageService;
        sendWeatherService = new SendWeatherByGeolocationService(new ApiConnectorService());
    }

    public void getWeather(Update update) {
        Location weatherLocation = update.getMessage().getLocation();
        sendWeatherService.setLat(weatherLocation.getLatitude());
        sendWeatherService.setLon(weatherLocation.getLongitude());

        String chatId = update.getMessage().getChatId().toString();

        try {
            sendMessageService.sendMessage(chatId, sendWeatherService.getWeatherInfo());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
