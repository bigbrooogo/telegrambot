package com.bigbrooogo.github.javarushtelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class JavarushTelegramBotApplication {

	public static void main(String[] args) throws TelegramApiException{
		SpringApplication.run(JavarushTelegramBotApplication.class, args);
	}
}
