package com.bigbrooogo.github.javarushtelegrambot;


import com.bigbrooogo.github.javarushtelegrambot.command.Command;
import com.bigbrooogo.github.javarushtelegrambot.command.CommandName;
import com.bigbrooogo.github.javarushtelegrambot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for StartCommand")

public class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }
}
