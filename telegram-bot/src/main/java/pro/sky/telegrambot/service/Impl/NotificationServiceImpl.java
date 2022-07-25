package pro.sky.telegrambot.service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Notification;
import pro.sky.telegrambot.repository.NotificationsRepository;
import pro.sky.telegrambot.service.NotificationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NotificationServiceImpl implements NotificationService {

    private static final String REGULAR_MESSAGE = "([0-9\\.\\:\\s]{16})(\\s)([\\W+]+)";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final NotificationsRepository notificationRepository;

    public NotificationServiceImpl(NotificationsRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> parse(String notificationBotAnswer) {
        Pattern pattern = Pattern.compile(REGULAR_MESSAGE);
        Matcher matcher = pattern.matcher(notificationBotAnswer);

        Notification result = null;
        if (matcher.matches()) {
            String notification_text = matcher.group(3);
            LocalDateTime notification_date = LocalDateTime.parse(matcher.group(1), DATE_TIME_FORMATTER);
            result = new Notification(notification_text, notification_date);
        }
        return Optional.ofNullable(result);
    }

    @Override
    public Notification schedule(Long chatId, Notification notification) {
        notification.setChat_id(chatId);
        return notificationRepository.save(notification);
    }

    @Override
    public void sendNotification(Consumer<Notification> notification) {
        Collection<Notification> notifications = notificationRepository.getNotification();
        notifications.forEach(notification);
        notificationRepository.saveAll(notifications);
    }
}
