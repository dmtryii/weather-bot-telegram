package com.dmtryii.weatherbot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherModel {
    String name;
    String mainInfo;
    Double temp;
    String info;
    Double humidity;
    String icon;
    Double speed;
}
