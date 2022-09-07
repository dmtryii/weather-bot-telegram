package com.dmtryii.weatherbot.service;

import java.io.IOException;

import com.dmtryii.weatherbot.model.WeatherModel;

public interface ApiConnectorByCity {
    void connectToApi(WeatherModel weatherModel, String city) throws IOException;
}
