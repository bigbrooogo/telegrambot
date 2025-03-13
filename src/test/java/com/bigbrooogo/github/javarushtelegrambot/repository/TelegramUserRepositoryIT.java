package com.bigbrooogo.github.javarushtelegrambot.repository;

import  com.bigbrooogo.github.javarushtelegrambot.repository.entity.TelegramUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)


public class TelegramUserRepositoryIT {
    @Autowired
    private TelegramUserRepository telegramUserRepository;

    @Sql(scripts = {"/sql/clearDBs.sql", "/sql/telegram-users.sql"})

    @Test
    public void shouldFindAllActiveTelegramUsers() {
        List<TelegramUser> users = telegramUserRepository.findAllByActiveTrue();
        Assertions.assertEquals(5, users.size());
    }
    @Test
    public void shouldFindAllTelegramUserById() {
        List<TelegramUser> users = telegramUserRepository.findAll();
        Assertions.assertEquals(8, users.size());
    }
    @Sql(scripts = {"/sql/clearDBs.sql"})
    @Test
    public void shouldntFindAny() {
        List<TelegramUser> users = telegramUserRepository.findAll();
        Assertions.assertEquals(0, users.size());
    }
    @Test
    public void shouldSaveTelegramUser() {
        TelegramUser user = new TelegramUser();
        user.setChatId("123456789");
        user.setActive(false);
        telegramUserRepository.save(user);

        Optional<TelegramUser> saved = telegramUserRepository.findById(user.getChatId());
        Assertions.assertTrue(saved.isPresent());
        Assertions.assertEquals(user, saved.get());
    }
    
}
