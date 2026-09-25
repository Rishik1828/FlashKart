package FlashKart.Order.OrderEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double totalAmount;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
