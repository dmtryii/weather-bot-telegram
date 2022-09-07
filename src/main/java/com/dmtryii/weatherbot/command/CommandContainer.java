package com.dmtryii.weatherbot.command;

import com.dmtryii.weatherbot.service.SendMessageBot;
import com.google.common.collect.ImmutableMap;

import static com.dmtryii.weatherbot.command.CommandName.*;

public class CommandContainer {
    ImmutableMap<String, Command> commandMap;

    private final Command unknownCommand;

    public CommandContainer(SendMessageBot sendMessageService){
    	commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(WEATHER.getCommandName(), new WeatherCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command getCommand(String commandInd) {
        return commandMap.getOrDefault(commandInd, unknownCommand);
    }
}
