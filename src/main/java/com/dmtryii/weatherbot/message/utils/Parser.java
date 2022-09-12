package com.dmtryii.weatherbot.message.utils;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static String toAppleEmoji(String openWeatherIcon) {
        Map<String, String> icons = new HashMap<>();
        icons.put("01", ":sunny:");
        icons.put("02", ":white_sun_with_small_cloud:");
        icons.put("03", "sun_behind_cloud");
        icons.put("04", ":cloud:");
        icons.put("09", ":cloud_with_rain:");
        icons.put("10", ":cloud_with_rain:");
        icons.put("11", ":thunder_cloud_and_rain:");
        icons.put("13", ":snowflake:");
        icons.put("50", ":fog:");

        return icons.get(openWeatherIcon.substring(0, 2));
    }
}
