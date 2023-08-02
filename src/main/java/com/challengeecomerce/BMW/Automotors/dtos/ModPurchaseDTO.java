package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.ModPurchase;
import com.challengeecomerce.BMW.Automotors.models.Purchase;

import java.time.LocalDateTime;

public class ModPurchaseDTO {
    private Long id;
    private Integer quantity;

    private LocalDateTime modPurchaseDate;

    private Purchase purchase;

    private Mod mod;

    public ModPurchaseDTO() {
    }

    public ModPurchaseDTO(ModPurchase modPurchase) {
        this.id = modPurchase.getId();
        this.quantity = modPurchase.getQuantity();
        this.modPurchaseDate = modPurchase.getModPurchaseDate();
        this.purchase = modPurchase.getPurchase();
        this.mod = modPurchase.getMod();
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
