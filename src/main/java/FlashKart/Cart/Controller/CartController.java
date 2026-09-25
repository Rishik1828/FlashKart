package FlashKart.Cart.Controller;

import FlashKart.Cart.DTO.AddToCart;
import FlashKart.Cart.Entity.CartEntity;
import FlashKart.Cart.Service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{id}")
    public ResponseEntity createCart(@PathVariable Long id) {
        return cartService.createCart(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @PostMapping("/{id}/items")
    public ResponseEntity addCartItem(@PathVariable Long id,@RequestBody AddToCart cartItem) {
        return cartService.addToCart(id,cartItem);
    }
    @PutMapping("/{id}/items/{productId}")
    public ResponseEntity updateCartItem(@PathVariable Long id,
                                         @PathVariable Long productId,
                                         @RequestParam Integer quantity) {
        return cartService.updateItem(id,productId,quantity);
    }
    @DeleteMapping("/{id}/items/{productId}")
    public ResponseEntity deleteItem(@PathVariable Long id,
                                     @PathVariable Long productId){
        return cartService.deleteItem(id,productId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCart(@PathVariable Long id) {
        return cartService.deleteCart(id);
    }
}
