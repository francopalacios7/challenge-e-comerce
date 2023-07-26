package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.ModPurchase;

public class ModPurchaseDTO {
    private Long id;
    private Integer quantity;

    public ModPurchaseDTO() {
    }

    public ModPurchaseDTO(ModPurchase modPurchase) {
        this.id = modPurchase.getId();
        this.quantity = modPurchase.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
