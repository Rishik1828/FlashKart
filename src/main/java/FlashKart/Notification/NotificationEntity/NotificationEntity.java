package FlashKart.Notification.NotificationEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private Boolean isRead;

    private LocalDateTime createdAt;
}