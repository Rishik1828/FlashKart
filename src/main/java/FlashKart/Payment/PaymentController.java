package FlashKart.Payment;

import FlashKart.Payment.DTO.CreatePaymentRequest;
import FlashKart.Payment.Entity.PaymentEntity;
import FlashKart.Payment.PaymentService.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentEntity createPayment(
            @RequestBody CreatePaymentRequest request) {

        return paymentService.createPayment(request);
    }

    @GetMapping("/{orderId}")
    public PaymentEntity getPayment(
            @PathVariable Long orderId) {

        return paymentService.getPaymentByOrderId(orderId);
    }
}