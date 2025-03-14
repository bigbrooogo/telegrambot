package com.bigbrooogo.github.javarushtelegrambot;

import com.bigbrooogo.github.javarushtelegrambot.bot.JavarushTelegrambot;
import com.bigbrooogo.github.javarushtelegrambot.service.SendBotMessageService;
import com.bigbrooogo.github.javarushtelegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private JavarushTelegrambot javarushTelegrambot;

    @BeforeEach
    public void init() {
        javarushTelegrambot = Mockito.mock(JavarushTelegrambot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushTelegrambot);
    }
    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(javarushTelegrambot).execute(sendMessage);
    }
}
