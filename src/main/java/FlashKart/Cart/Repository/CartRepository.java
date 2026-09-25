package FlashKart.Cart.Repository;

import FlashKart.Cart.Entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
    Optional<CartEntity> findByUserId(Long userId);

    CartEntity getCartEntityByUserId(Long userId);
}
