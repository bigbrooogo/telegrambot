package com.bigbrooogo.github.javarushtelegrambot.command;

import com.bigbrooogo.github.javarushtelegrambot.repository.TelegramUserService;
import com.bigbrooogo.github.javarushtelegrambot.service.SendBotMessageService;

import java.util.HashMap;

import static com.bigbrooogo.github.javarushtelegrambot.command.CommandName.*;


public class CommandContainer {

    private final HashMap<String, Command> map;

    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.map = new HashMap<>();
        map.put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService));
        map.put(STOP.getCommandName(), new StopCommand(sendBotMessageService,telegramUserService));
        map.put(HELP.getCommandName(), new HelpCommand(sendBotMessageService));
        map.put(NO_COMMAND.getCommandName(), new NoCommand(sendBotMessageService));
        map.put(STAT.getCommandName(), new StatCommand(sendBotMessageService,telegramUserService));
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }
    public Command getCommand(String commandName) {
        return map.getOrDefault(commandName, unknownCommand);
    }
}
