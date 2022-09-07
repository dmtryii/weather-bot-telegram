package com.dmtryii.weatherbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

import com.dmtryii.weatherbot.service.SendMessageBot;

public class StartCommand implements Command{
    private final SendMessageBot sendMessageService;

    public StartCommand(SendMessageBot sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageService.sendMessage(chatId, CommandValue.START_COMMAND);
    }
}
