package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chat_id;
    private String notification_text;
    private LocalDateTime notification_date;

    public Notification(String notification_text, LocalDateTime notification_date) {
        this.notification_text = notification_text;
        this.notification_date = notification_date;
    }

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getNotification_text() {
        return notification_text;
    }

    public void setNotification_text(String notification_text) {
        this.notification_text = notification_text;
    }

    public LocalDateTime getNotification_date() {
        return notification_date;
    }

    public void setNotification_date(LocalDateTime notification_date) {
        this.notification_date = notification_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && Objects.equals(chat_id, that.chat_id) && Objects.equals(notification_text, that.notification_text) && Objects.equals(notification_date, that.notification_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chat_id, notification_text, notification_date);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", chat_id=" + chat_id +
                ", notification_text='" + notification_text + '\'' +
                ", notification_date=" + notification_date +
                '}';
    }
}

