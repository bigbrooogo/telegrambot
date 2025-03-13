package com.bigbrooogo.github.javarushtelegrambot;


import com.bigbrooogo.github.javarushtelegrambot.command.Command;
import com.bigbrooogo.github.javarushtelegrambot.command.CommandName;
import com.bigbrooogo.github.javarushtelegrambot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for NoCommand")

public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.NO_COMMAND.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NoCommand.NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
