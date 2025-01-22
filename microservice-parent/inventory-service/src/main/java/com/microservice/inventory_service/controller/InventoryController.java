package com.microservice.inventory_service.controller;

import com.microservice.inventory_service.dto.InventoryResponse;
import com.microservice.inventory_service.model.Inventory;
import com.microservice.inventory_service.service.InventortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


    private final InventortyService inventortyService;

    @Autowired
    public InventoryController(InventortyService inventortyService) {
        this.inventortyService = inventortyService;
    }

// http://localhost:8082/api/inventory/iphone-13

//    @GetMapping("/{sku-code}")
//    @ResponseStatus(HttpStatus.OK)
//    public Boolean isInStatus(@PathVariable String skuCode) {
//
//        return inventortyService.isInStock(skuCode);
//    }



// http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStatus(@RequestParam List<String> skuCode) {

        return inventortyService.isInStock(skuCode);
    }

}
