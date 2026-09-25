package FlashKart.Inventory.Service;

import FlashKart.Inventory.DTO.CreateInventoryRequest;
import FlashKart.Inventory.DTO.QuantityRequest;
import FlashKart.Inventory.Entity.InventoryEntity;
import FlashKart.Inventory.Repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    InventoryRepository inventoryRepository;
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public InventoryEntity createInventory(CreateInventoryRequest request) {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setProductId(request.getProductId());
        inventoryEntity.setAvailableQuantity(request.getQuantity());
        inventoryEntity.setReservedQuantity(0);
        inventoryRepository.save(inventoryEntity);
        return inventoryEntity;
    }

    public InventoryEntity getInventory(Long productId) {
        return inventoryRepository.findByProductId(productId).
                orElseThrow(()-> new RuntimeException("Product not found"));
    }

    public InventoryEntity updateInventory(Long productId, QuantityRequest request ) {
        InventoryEntity inventoryEntity = getInventory(productId);
        inventoryEntity.setAvailableQuantity(request.getQuantity());
        return inventoryRepository.save(inventoryEntity);
    }

    public InventoryEntity reserveInventory(Long productId, QuantityRequest request) {
        InventoryEntity inventoryEntity = getInventory(productId);
        if(inventoryEntity.getAvailableQuantity() < request.getQuantity()) {
            throw new RuntimeException("Not enough available quantity");
        }
        inventoryEntity.setAvailableQuantity(inventoryEntity.getAvailableQuantity() - request.getQuantity());
        inventoryEntity.setReservedQuantity(inventoryEntity.getReservedQuantity() + request.getQuantity());
        return inventoryRepository.save(inventoryEntity);
    }

    public InventoryEntity releaseInventory(Long productId, QuantityRequest request) {
        InventoryEntity inventoryEntity = getInventory(productId);
        int quantity = request.getQuantity();
        if (inventoryEntity.getReservedQuantity() < quantity) {
            throw new RuntimeException("Not enough reserved stock");
        }
        inventoryEntity.setReservedQuantity(inventoryEntity.getReservedQuantity() - request.getQuantity());
        inventoryEntity.setAvailableQuantity(inventoryEntity.getAvailableQuantity() + request.getQuantity());
        return inventoryRepository.save(inventoryEntity);
    }
}
