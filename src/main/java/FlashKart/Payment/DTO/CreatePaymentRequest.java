package FlashKart.Payment.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {

    private Long orderId;

    private Double amount;
}