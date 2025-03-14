package com.bigbrooogo.github.javarushtelegrambot;

import com.bigbrooogo.github.javarushtelegrambot.command.*;
import com.bigbrooogo.github.javarushtelegrambot.repository.TelegramUserService;
import com.bigbrooogo.github.javarushtelegrambot.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for CommandContainer")

public class CommandContainerTest {

    private SendBotMessageService sendBotMessageService;
    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService,telegramUserService);
    }
    @Test
    public void shouldgGetAllExistingCommands() throws TelegramApiException {
        for(CommandName com : CommandName.values()) {
            Command command = commandContainer.getCommand(com.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        }
    }
    @Test
    public void shouldgReturnUnknownCommand() throws TelegramApiException {
        String unknownCommandName = "/blabla";
        Command command = commandContainer.getCommand(unknownCommandName);
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}
