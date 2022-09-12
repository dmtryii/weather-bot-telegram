package com.dmtryii.weatherbot.message;

import com.dmtryii.weatherbot.message.utils.Parser;
import com.dmtryii.weatherbot.model.WeatherModel;
import com.vdurmont.emoji.EmojiParser;

public class WeatherMessage {
    WeatherModel weatherModel;

    public WeatherMessage(WeatherModel weatherModel){
        this.weatherModel = weatherModel;
    }

    public String weatherMessage(){
        return EmojiParser.parseToUnicode(
                weatherModel.getName() + ": "
                + weatherModel.getInfo() + " " + Parser.toAppleEmoji(weatherModel.getIcon()) + "\n"
                + "temp: " + weatherModel.getTemp().intValue() + "°C\n"
                + "wind: " + weatherModel.getSpeed() + "m/s\n"
                + "humidity: " + weatherModel.getHumidity()
        );
    }

}
