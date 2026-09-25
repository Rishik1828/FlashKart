package FlashKart.Inventory.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateInventoryRequest {
    private Long productId;
    private int quantity;
}
