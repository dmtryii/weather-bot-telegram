package com.dmtryii.weatherbot.command;

public interface CommandValue {
	String UNKNOWN_COMMAND = "Type /help for a list of commands";
    String START_COMMAND = "@WeatherApplicationBot started\n" +
            "Please enter the city name as '/weather city_name' " +
            "or send as 'location'\n\n" +
            ">City, Country\n" +
            ">Location";
    String HELP_COMMAND = "/weather 'city name' - get the weather " +
            "or send your 'location'\n\n";
}
