package FlashKart.Order.OrderService;

import FlashKart.Order.DTO.OrderRequestDTO;
import FlashKart.Order.OrderEntity.OrderEntity;
import FlashKart.Order.OrderEntity.OrderStatus;
import FlashKart.Order.OrderRepository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public OrderEntity createOrder(OrderRequestDTO orderRequestDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(orderRequestDTO.getUserId());
        orderEntity.setTotalAmount(orderRequestDTO.getTotalAmount());
        orderEntity.setStatus(OrderStatus.CREATED);
        orderEntity.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(orderEntity);
    }

    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Order not found"));
    }

    public List<OrderEntity> getAllOrders(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public OrderEntity cancelOrderById(Long orderId) {
        OrderEntity orderEntity = getOrderById(orderId);
        orderRepository.delete(orderEntity);
        return orderEntity;
    }

}
