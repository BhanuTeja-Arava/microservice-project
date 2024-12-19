package com.microservice.inventory_service.controller;

import com.microservice.inventory_service.service.InventortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


    private final InventortyService inventortyService;

    @Autowired
    public InventoryController(InventortyService inventortyService) {
        this.inventortyService = inventortyService;
    }

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStatus(@PathVariable String skuCode) {

        return inventortyService.isInStock(skuCode);
    }

}
