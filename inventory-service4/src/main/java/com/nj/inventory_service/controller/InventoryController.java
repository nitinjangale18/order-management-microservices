package com.nj.inventory_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nj.inventory_service.entity.Inventory;
import com.nj.inventory_service.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<Inventory> addInventory(
            @RequestBody Inventory inventory) {

        Inventory savedInventory =
                inventoryService.addInventory(inventory);

        return new ResponseEntity<>(
                savedInventory,
                HttpStatus.CREATED);
    }

}