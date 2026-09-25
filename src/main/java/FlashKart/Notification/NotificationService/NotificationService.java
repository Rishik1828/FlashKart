package FlashKart.Notification.NotificationService;

import FlashKart.Notification.DTO.CreateNotificationRequest;
import FlashKart.Notification.NotificationEntity.NotificationEntity;
import FlashKart.Notification.NotificationRepository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(
            NotificationRepository notificationRepository) {

        this.notificationRepository = notificationRepository;
    }

    public NotificationEntity createNotification(
            CreateNotificationRequest request) {

        NotificationEntity notification =
                new NotificationEntity();

        notification.setUserId(request.getUserId());
        notification.setMessage(request.getMessage());
        notification.setType(request.getType());
        notification.setIsRead(false);
        notification.setCreatedAt(LocalDateTime.now());

        return notificationRepository.save(notification);
    }

    public List<NotificationEntity> getNotifications(
            Long userId) {

        return notificationRepository.findByUserId(userId);
    }
}