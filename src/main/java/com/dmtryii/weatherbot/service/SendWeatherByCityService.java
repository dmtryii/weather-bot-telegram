package com.dmtryii.weatherbot.service;

import java.io.IOException;

import com.dmtryii.weatherbot.message.WeatherMessage;
import com.dmtryii.weatherbot.model.WeatherModel;

public class SendWeatherByCityService {
	private String city;

    ApiConnectorService apiConnectorService;
    WeatherModel weatherModel;
    WeatherMessage message;

    public SendWeatherByCityService(ApiConnectorService apiConnectorService){
        this.apiConnectorService = apiConnectorService;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getWeatherInfo() throws IOException {
        weatherModel = new WeatherModel();
        message = new WeatherMessage(weatherModel);
        apiConnectorService.connectToApi(weatherModel, city);

        return message.weatherMessage();
    }
}
