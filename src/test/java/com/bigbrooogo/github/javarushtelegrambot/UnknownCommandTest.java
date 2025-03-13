package com.bigbrooogo.github.javarushtelegrambot;


import com.bigbrooogo.github.javarushtelegrambot.command.Command;
import com.bigbrooogo.github.javarushtelegrambot.command.UnknownCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for UnknownCommand")

public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "blablabla";
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
