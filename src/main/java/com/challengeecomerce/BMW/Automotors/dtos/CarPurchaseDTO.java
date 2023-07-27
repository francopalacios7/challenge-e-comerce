package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.CarPurchase;
import com.challengeecomerce.BMW.Automotors.models.Purchase;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CarPurchaseDTO {
    private Long id;
    private Integer quantity;
    private Purchase purchase;

    public CarPurchaseDTO() {
    }

    public CarPurchaseDTO(CarPurchase carPurchase) {
        this.id = carPurchase.getId();
        this.quantity = carPurchase.getQuantity();
        this.purchase = carPurchase.getPurchase();
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
