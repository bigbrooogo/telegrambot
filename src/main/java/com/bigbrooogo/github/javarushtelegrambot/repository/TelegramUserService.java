package com.bigbrooogo.github.javarushtelegrambot.repository;

import com.bigbrooogo.github.javarushtelegrambot.repository.entity.TelegramUser;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

public interface TelegramUserService {
    void save(TelegramUser telegramUser);

    List<TelegramUser> retrieveAllActiveUsers();

    Optional<TelegramUser> findByChatId(String chatId);
}
