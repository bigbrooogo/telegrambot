package com.bigbrooogo.github.javarushtelegrambot.bot;

import com.bigbrooogo.github.javarushtelegrambot.command.CommandContainer;
import com.bigbrooogo.github.javarushtelegrambot.command.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.bigbrooogo.github.javarushtelegrambot.command.CommandName.NO_COMMAND;

@Component
public class JavarushTelegrambot extends TelegramLongPollingBot {

    private final CommandContainer commandContainer;

    public JavarushTelegrambot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    public final String COMMAND_PREFIX = "/";

    @Value(value = "${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith("/")) {
                String command = message.split(" ")[0].trim();
                commandContainer.getCommand(command).execute(update);
            }
            else commandContainer.getCommand(NO_COMMAND.getCommandName()).execute(update);



        }

    }
}
