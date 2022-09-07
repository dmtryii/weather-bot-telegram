package com.dmtryii.weatherbot.service;

import com.dmtryii.weatherbot.model.WeatherModel;

import java.io.IOException;

public interface ApiConnectorByGeolocation {
    void connectToApi(WeatherModel weatherModel, Double lat, Double lon) throws IOException;
}
