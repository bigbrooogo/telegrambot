package com.bigbrooogo.github.javarushtelegrambot;

import com.bigbrooogo.github.javarushtelegrambot.command.Command;
import com.bigbrooogo.github.javarushtelegrambot.command.CommandName;
import com.bigbrooogo.github.javarushtelegrambot.command.StartCommand;
import com.bigbrooogo.github.javarushtelegrambot.command.StatCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit-level testing for StatCommand")
public class StatCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return CommandName.STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(StatCommand.STAT_MESSAGE,0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService,telegramUserService);
    }
}
