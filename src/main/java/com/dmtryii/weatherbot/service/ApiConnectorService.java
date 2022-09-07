package com.dmtryii.weatherbot.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dmtryii.weatherbot.config.ApiConfig;
import com.dmtryii.weatherbot.model.WeatherModel;

public class ApiConnectorService implements ApiConnectorByCity, ApiConnectorByGeolocation {
    private StringBuilder result;

    @Override
    public void connectToApi(WeatherModel weatherModel, String city) throws IOException {
    	URL url = new URL("http://api.openweathermap.org/data/2.5/weather" +
                "?q=" + city +
                "&appid=" + ApiConfig.appId +
                "&units=" + ApiConfig.units +
                "&lang=" + ApiConfig.lang);

        scanningValueFromURL(url);
        getWeatherInfo(weatherModel, result);
    }

    @Override
    public void connectToApi(WeatherModel weatherModel, Double lat, Double lon) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather" +
                "?lat=" + lat +
                "&lon=" + lon +
                "&appid=" + ApiConfig.appId +
                "&units=" + ApiConfig.units +
                "&lang=" + ApiConfig.lang);

        scanningValueFromURL(url);
        getWeatherInfo(weatherModel, result);
    }

    public void getWeatherInfo(WeatherModel weatherModel, StringBuilder result){
        JSONObject object = new JSONObject(result.toString());

        weatherModel.setName(object.getString("name"));

        JSONArray weatherInfo = (JSONArray) object.get("weather");
        JSONObject description = (JSONObject) weatherInfo.iterator().next();
        weatherModel.setInfo(description.getString("description"));

        JSONObject main = object.getJSONObject("main");
        weatherModel.setTemp(main.getDouble("temp"));
        weatherModel.setHumidity(main.getDouble("humidity"));

        JSONObject wind = object.getJSONObject("wind");
        weatherModel.setSpeed(wind.getDouble("speed"));
    }

    public void scanningValueFromURL(URL url) {
        Scanner scanner;
        try {
            scanner = new Scanner((InputStream) url.getContent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result = new StringBuilder();

        while(scanner.hasNext()) {
            result.append(scanner.nextLine());
        }
    }
}
