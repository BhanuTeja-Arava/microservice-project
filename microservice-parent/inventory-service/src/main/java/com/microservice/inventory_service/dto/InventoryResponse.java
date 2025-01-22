package com.microservice.inventory_service.dto;


import lombok.*;

@Data
@Builder
public class InventoryResponse {

    @Getter
    @Setter
    private String skuCode;
    private boolean isInStock;

    public InventoryResponse(String skuCode, boolean isInStock) {
        this.skuCode = skuCode;
        this.isInStock = isInStock;
    }

    public InventoryResponse() {
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public static InventoryResponseBuilder builder() {
        return new InventoryResponseBuilder();
    }

    public static class InventoryResponseBuilder {
        private String skuCode;
        private boolean isInStock;

        public InventoryResponseBuilder skuCode(String skuCode) {
            this.skuCode = skuCode;
            return this;
        }

        public InventoryResponseBuilder isInStock(boolean isInStock) {
            this.isInStock = isInStock;
            return this;
        }

        public InventoryResponse build() {
            return new InventoryResponse(skuCode, isInStock);
        }

    }
}
