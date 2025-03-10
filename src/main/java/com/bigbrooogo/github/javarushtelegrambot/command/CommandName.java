package com.bigbrooogo.github.javarushtelegrambot.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO_COMMAND("^//.*");


    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }
    public String getCommandName() {
        return commandName;
    }

}
