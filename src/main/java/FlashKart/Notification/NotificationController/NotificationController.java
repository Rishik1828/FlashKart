package FlashKart.Notification.NotificationController;

import FlashKart.Notification.DTO.CreateNotificationRequest;
import FlashKart.Notification.NotificationEntity.NotificationEntity;
import FlashKart.Notification.NotificationService.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    @PostMapping
    public NotificationEntity createNotification(
            @RequestBody CreateNotificationRequest request) {

        return notificationService.createNotification(request);
    }

    @GetMapping("/{userId}")
    public List<NotificationEntity> getNotifications(
            @PathVariable Long userId) {

        return notificationService.getNotifications(userId);
    }
}