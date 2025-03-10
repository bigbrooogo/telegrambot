package com.bigbrooogo.github.javarushtelegrambot;


import com.bigbrooogo.github.javarushtelegrambot.command.*;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for HelpCommand")

public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
