package com.bigbrooogo.github.javarushtelegrambot.command;

import com.bigbrooogo.github.javarushtelegrambot.service.SendBotMessageService;
import com.bigbrooogo.github.javarushtelegrambot.repository.TelegramUserService;
import com.bigbrooogo.github.javarushtelegrambot.repository.entity.TelegramUser;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Работа с ботом закончена";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, STOP_MESSAGE);
        telegramUserService.findByChatId(chatId).ifPresent(
                telegramUser -> {telegramUser.setActive(false);
                    telegramUserService.save(telegramUser);});

    }

}
