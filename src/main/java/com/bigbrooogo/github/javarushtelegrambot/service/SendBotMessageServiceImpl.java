package com.bigbrooogo.github.javarushtelegrambot.service;

import com.bigbrooogo.github.javarushtelegrambot.bot.JavarushTelegrambot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final JavarushTelegrambot javarushTelegrambot;

    @Autowired
    public SendBotMessageServiceImpl(JavarushTelegrambot javarushTelegrambot) {
        this.javarushTelegrambot = javarushTelegrambot;
    }
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            javarushTelegrambot.execute(sendMessage);
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
