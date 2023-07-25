package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.Purchase;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

public class ModDTO {

    private Long id;
    private String name;

    private Double price;

    private CarColor carColor;

    private Purchase purchase;

    public ModDTO() {
    }

    public ModDTO(Mod mod) {
        this.id = mod.getId();
        this.name = mod.getName();
        this.price = mod.getPrice();
        this.carColor = mod.getCarColor();
        this.purchase = mod.getPurchase();
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
