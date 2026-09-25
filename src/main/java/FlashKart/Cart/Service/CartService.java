package FlashKart.Cart.Service;

import FlashKart.Cart.DTO.AddToCart;
import FlashKart.Cart.Entity.CartEntity;
import FlashKart.Cart.Entity.CartItemEntity;
import FlashKart.Cart.Repository.CartItemRepository;
import FlashKart.Cart.Repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    CartRepository cartRepository;
    CartItemRepository cartItemRepository;
    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public ResponseEntity createCart(Long id) {
        if(cartRepository.findByUserId(id).isPresent()) {
            throw new RuntimeException("Cart Already Exists");
        }
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUserId(id);
        cartRepository.save(cartEntity);
        return ResponseEntity.ok(cartEntity);
    }

    public ResponseEntity getCart(Long id) {
        Optional<CartEntity> optional = cartRepository.findByUserId(id);
        if(!optional.isPresent()) {
            throw new RuntimeException("Cart Not Exists");
        }
        return ResponseEntity.ok(optional.get());
    }


    public ResponseEntity addToCart(Long id, AddToCart request) {
        CartEntity cart=cartRepository.getCartEntityByUserId(id);
        CartItemEntity existing=cartItemRepository.
                findByCartCartIdAndProductId(cart.getCartId(),request.getProductID()).orElse(null);
        if(existing==null) {
            CartItemEntity cartItemEntity=new CartItemEntity();
            cartItemEntity.setProductId(request.getProductID());
            cartItemEntity.setQuantity(request.getQuantity());
            cart.addItem(cartItemEntity);
        }
        else{
            existing.setQuantity(existing.getQuantity()+request.getQuantity());
            cartItemRepository.save(existing);
        }
        return ResponseEntity.ok(cartRepository.save(cart));
    }

    public ResponseEntity updateItem(Long id,Long productId,Integer quantity) {
        CartEntity cart=cartRepository.getCartEntityByUserId(id);
        CartItemEntity existing=cartItemRepository
                .findByCartCartIdAndProductId(cart.getCartId(),productId).
                orElseThrow(()->new RuntimeException("Product Not Found In Cart"));
        existing.setQuantity(quantity);
        cartItemRepository.save(existing);
        return ResponseEntity.ok(cart);
    }

    public ResponseEntity deleteItem(Long id,Long productId) {
        CartEntity cart=cartRepository.getCartEntityByUserId(id);
        CartItemEntity existing=cartItemRepository.
                findByCartCartIdAndProductId(cart.getCartId(), productId).
                orElseThrow(()->new RuntimeException("Product Not Found In Cart"));
        cart.removeItem(existing);
        return ResponseEntity.ok(cart);
    }

    public ResponseEntity deleteCart(Long userId) {
        CartEntity cart = cartRepository.getCartEntityByUserId(userId);
        cartRepository.delete(cart);
        return ResponseEntity.ok("Cart Deleted");
    }
}
