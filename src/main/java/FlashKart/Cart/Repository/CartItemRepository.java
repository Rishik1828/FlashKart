package FlashKart.Cart.Repository;

import FlashKart.Cart.Entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity,Long> {
    Optional<CartItemEntity> findByCartCartIdAndProductId(Long cartId, Long productId);
}
