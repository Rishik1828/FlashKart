package FlashKart.Order.OrderRepository;

import FlashKart.Order.OrderEntity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    Optional<OrderEntity> findById(Long id);

    List<OrderEntity> findAllByUserId(Long userId);
}
