package FlashKart.Cart.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class CartEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private Long userId;

    @OneToMany(mappedBy ="cart",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    List<CartItemEntity>list=new ArrayList<>();

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemEntity> getList() {
        return list;
    }

    public void setList(List<CartItemEntity> list) {
        this.list = list;
    }
    public void addItem(CartItemEntity item) {
        list.add(item);
        item.setCart(this);
    }
    public void removeItem(CartItemEntity item) {
        list.remove(item);
        item.setCart(null);
    }
}
