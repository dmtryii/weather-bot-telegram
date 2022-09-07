package com.dmtryii.weatherbot.service;

import com.dmtryii.weatherbot.message.WeatherMessage;
import com.dmtryii.weatherbot.model.WeatherModel;

import java.io.IOException;

public class SendWeatherByGeolocationService {
    Double lat;
    Double lon;

    ApiConnectorService apiConnectorService;
    WeatherModel weatherModel;
    WeatherMessage message;

    public SendWeatherByGeolocationService(ApiConnectorService apiConnectorService) {
        this.apiConnectorService = apiConnectorService;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getWeatherInfo() throws IOException {
        weatherModel = new WeatherModel();
        message = new WeatherMessage(weatherModel);
        apiConnectorService.connectToApi(weatherModel, lat, lon);

        return message.weatherMessage();
    }
}
