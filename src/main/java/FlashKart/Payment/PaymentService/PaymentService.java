package FlashKart.Payment.PaymentService;

import FlashKart.Payment.DTO.CreatePaymentRequest;
import FlashKart.Payment.Entity.PaymentEntity;
import FlashKart.Payment.Entity.PaymentStatus;
import FlashKart.Payment.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentEntity createPayment(
            CreatePaymentRequest request) {

        PaymentEntity payment = new PaymentEntity();

        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setStatus(PaymentStatus.PENDING);
        payment.setCreatedAt(LocalDateTime.now());

        // Temporary simulation of payment
        payment.setStatus(PaymentStatus.SUCCESS);

        return paymentRepository.save(payment);
    }

    public PaymentEntity getPaymentByOrderId(Long orderId) {

        return paymentRepository.findByOrderId(orderId)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found"));
    }
}