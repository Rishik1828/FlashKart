package FlashKart.Notification.DTO;

import FlashKart.Notification.NotificationEntity.NotificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNotificationRequest {

    private Long userId;

    private String message;

    private NotificationType type;
}