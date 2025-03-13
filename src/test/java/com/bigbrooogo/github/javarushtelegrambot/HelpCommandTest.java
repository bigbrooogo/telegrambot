package com.bigbrooogo.github.javarushtelegrambot;


import com.bigbrooogo.github.javarushtelegrambot.command.Command;
import com.bigbrooogo.github.javarushtelegrambot.command.CommandName;
import com.bigbrooogo.github.javarushtelegrambot.command.HelpCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for HelpCommand")

public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
