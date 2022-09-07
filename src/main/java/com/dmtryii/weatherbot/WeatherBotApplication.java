package com.dmtryii.weatherbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.dmtryii.weatherbot.bot.WeatherBot;

public class WeatherBotApplication {
    public static void main(String[] args ) {
    	try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new WeatherBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}    
}
