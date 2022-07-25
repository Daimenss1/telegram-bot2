package pro.sky.telegrambot.service;

import pro.sky.telegrambot.model.Notification;

import java.util.Optional;
import java.util.function.Consumer;

public interface NotificationService {
    Optional<Notification> parse(String notificationBotAnswer);

    Notification schedule(Long chatId, Notification notification);

    void sendNotification(Consumer<Notification> notification);
}