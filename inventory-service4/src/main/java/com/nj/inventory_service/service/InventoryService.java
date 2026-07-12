package com.nj.inventory_service.service;

import org.springframework.stereotype.Service;

import com.nj.inventory_service.entity.Inventory;
import com.nj.inventory_service.repository.InventoryRepository;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void reduceStock(String productName, Integer orderedQuantity) {

        Inventory inventory = inventoryRepository
                .findByProductName(productName)
                .orElseThrow(() ->
                        new RuntimeException("Product not found: " + productName));

        if (inventory.getAvailableQuantity() < orderedQuantity) {
            throw new RuntimeException(
                    "Insufficient stock for product: " + productName);
        }

        inventory.setAvailableQuantity(
                inventory.getAvailableQuantity() - orderedQuantity);

        inventoryRepository.save(inventory);

        System.out.println(
                "Stock reduced. Remaining quantity: "
                        + inventory.getAvailableQuantity());
    }
}