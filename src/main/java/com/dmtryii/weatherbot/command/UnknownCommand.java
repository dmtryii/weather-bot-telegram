package com.dmtryii.weatherbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.dmtryii.weatherbot.service.SendMessageBot;

public class UnknownCommand implements Command{
	private final SendMessageBot sendMessageService;

    public UnknownCommand(SendMessageBot sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chaId = update.getMessage().getChatId().toString();
        sendMessageService.sendMessage(chaId, CommandValue.UNKNOWN_COMMAND);
    }
}
