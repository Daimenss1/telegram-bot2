package pro.sky.telegrambot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.sky.telegrambot.model.Notification;

import java.util.Collection;

public interface NotificationsRepository extends JpaRepository<Notification, Long> {

    @Query(value = "SELECT * FROM notification WHERE notification_date = CURRENT_TIMESTAMP", nativeQuery = true)
    Collection<Notification> getNotification();
}
