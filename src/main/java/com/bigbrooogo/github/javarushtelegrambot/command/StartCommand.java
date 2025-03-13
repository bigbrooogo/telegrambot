package com.bigbrooogo.github.javarushtelegrambot.command;

import com.bigbrooogo.github.javarushtelegrambot.repository.TelegramUserService;
import com.bigbrooogo.github.javarushtelegrambot.repository.entity.TelegramUser;
import com.bigbrooogo.github.javarushtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String START_MESSAGE = "Привет. Я Telegram Bot bigbrooogo.";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService1) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService1;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                telegramUser -> {telegramUser.setActive(true);
                    telegramUserService.save(telegramUser);},
                () -> {TelegramUser telegramUser = new TelegramUser();
                      telegramUser.setActive(true);
                      telegramUser.setChatId(chatId);
                      telegramUserService.save(telegramUser);
                });
        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
