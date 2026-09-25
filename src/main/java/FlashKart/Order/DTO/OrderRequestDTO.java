package FlashKart.Order.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private Long userId;
    private Double totalAmount;
}
