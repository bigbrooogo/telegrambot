package com.bigbrooogo.github.javarushtelegrambot;

import com.bigbrooogo.github.javarushtelegrambot.bot.JavarushTelegrambot;
import com.bigbrooogo.github.javarushtelegrambot.command.*;
import com.bigbrooogo.github.javarushtelegrambot.command.CommandName.*;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class JavarushTelegramBotApplication {

	public static void main(String[] args) throws TelegramApiException{
		//SpringApplication.run(JavarushTelegramBotApplication.class, args);
		CommandContainer cc = new CommandContainer(new SendBotMessageServiceImpl(new JavarushTelegrambot()));
		for(CommandName com : CommandName.values()) {
			System.out.println(com.getCommandName());
			Command command = cc.getCommand(com.getCommandName());
			System.out.println(command.getClass());
			//Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
		}
	}
}
