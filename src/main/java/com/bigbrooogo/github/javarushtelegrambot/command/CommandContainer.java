package com.bigbrooogo.github.javarushtelegrambot.command;

import java.util.HashMap;

import static com.bigbrooogo.github.javarushtelegrambot.command.CommandName.*;


public class CommandContainer {

    private final HashMap<String, Command> map;

    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        this.map = new HashMap<>();
        map.put(START.getCommandName(), new StartCommand(sendBotMessageService));
        map.put(STOP.getCommandName(), new StopCommand(sendBotMessageService));
        map.put(HELP.getCommandName(), new HelpCommand(sendBotMessageService));
        map.put(NO_COMMAND.getCommandName(), new NoCommand(sendBotMessageService));
        unknownCommand = new UnknownCommand(sendBotMessageService);
        System.out.println(map.toString());
    }
    public Command getCommand(String commandName) {
        return map.getOrDefault(commandName, unknownCommand);
    }
}
