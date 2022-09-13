package com.dmtryii.weatherbot.message.utils;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static String toAppleEmoji(String openWeatherIcon) {
        Map<String, String> icons = new HashMap<>();
        icons.put("01", ":sunny:");
        icons.put("02", ":partly_sunny:");
        icons.put("03", ":partly_sunny:");
        icons.put("04", ":cloud:");
        icons.put("09", ":umbrella:");
        icons.put("10", ":umbrella:");
        icons.put("11", ":umbrella:" + ":zap:");
        icons.put("13", ":snowflake:");
        icons.put("50", ":fog:");

        return icons.get(openWeatherIcon.substring(0, 2));
    }
}
