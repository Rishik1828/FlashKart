package FlashKart.Order.OrderController;

import FlashKart.Order.DTO.OrderRequestDTO;
import FlashKart.Order.OrderEntity.OrderEntity;
import FlashKart.Order.OrderService.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @GetMapping("/user/{userId}")
    public List<OrderEntity> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getAllOrders(userId);
    }

    @PutMapping("/user/{orderId}/cancel")
    public OrderEntity cancelOrderById(@PathVariable Long orderId) {
        return orderService.cancelOrderById(orderId);
    }
}
