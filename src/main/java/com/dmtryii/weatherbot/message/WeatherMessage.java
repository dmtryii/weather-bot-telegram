package com.dmtryii.weatherbot.message;

import com.dmtryii.weatherbot.model.WeatherModel;

public class WeatherMessage {
    WeatherModel weatherModel;

    public WeatherMessage(WeatherModel weatherModel){
        this.weatherModel = weatherModel;
    }

    public String weatherMessage(){
        return weatherModel.getName() + ": "
                + weatherModel.getInfo() + "\n"
                + "temp: " + weatherModel.getTemp().intValue() + "°C\n"
                + "wind: " + weatherModel.getSpeed() + "m/s\n"
                + "humidity: " + weatherModel.getHumidity();
    }
}
