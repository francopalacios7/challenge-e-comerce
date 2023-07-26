package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.CarModPurchase;

public class CarModPurchaseDTO {
    private Long id;
    private Integer quantity;

    public CarModPurchaseDTO() {
    }

    public CarModPurchaseDTO(CarModPurchase carModPurchase) {
        this.id = carModPurchase.getId();
        this.quantity = carModPurchase.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
