package FlashKart.Inventory.Controller;

import FlashKart.Inventory.DTO.CreateInventoryRequest;
import FlashKart.Inventory.DTO.QuantityRequest;
import FlashKart.Inventory.Entity.InventoryEntity;
import FlashKart.Inventory.Service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public InventoryEntity createInventory(@RequestBody CreateInventoryRequest request) {
        return inventoryService.createInventory(request);
    }

    @GetMapping("/{productId}")
    public InventoryEntity getInventory(@PathVariable Long productId) {
        return inventoryService.getInventory(productId);
    }

    @PutMapping("/{productId}")
    public InventoryEntity updateInventory(@PathVariable Long productId,
                                           @RequestBody QuantityRequest request) {
        return inventoryService.updateInventory(productId,request);
    }

    @PostMapping("/{productId}/reserve")
    public InventoryEntity reserveInventory(@PathVariable Long productId,
                                            @RequestBody QuantityRequest request) {
        return inventoryService.reserveInventory(productId,request);
    }

    @PostMapping("/{productId}/release")
    public InventoryEntity releaseInventory(@PathVariable Long productId,
                                            @RequestBody QuantityRequest request) {
        return inventoryService.releaseInventory(productId,request);
    }
}
