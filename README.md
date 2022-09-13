# Telegram Weather Bot
Telegram bot to get weather forecast ⛅

This Telegram Bot takes user's location as text or GPS coordinates and then informs about its current weather-cast.

Weather information is supplied by [OpenWeatherMap](https://openweathermap.org/).

When developing, the "Team" pattern was used.

### Dependencies:
To work with [Telegram](https://github.com/rubenlagus/TelegramBots), the `org.telegram` library was used, connected via `pom.xml`:

```xml
<dependency>
    <groupId>org.telegram</groupId>
    <artifactId>telegrambots</artifactId>
    <version>6.1.0</version>
</dependency>
```

### Config:
`com/dmtryii/weatherbot/config/ApiConfig.java`
````java
public interface ApiConfig {
	String appId = "your_appId";
	String units = "metric";
	String lang = "en";
}
````
`com/dmtryii/weatherbot/config/BotConfig.java`
````java
public interface BotConfig {
    String botName = "your_bot_name";
    String botToken = "your_bot_token";
}
````

### Screenshots:

![](../../Desktop/tg-photo.png)

### What you need to run the app:
* Java runtime installed
* Clone this repository
* Change the value in the config file
* Run application!





