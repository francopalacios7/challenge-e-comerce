package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;

@Entity
public class CarModPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carMod_id")
    private CarMod carMod;

    public CarModPurchase() {
    }

    public CarModPurchase(Integer quantity, Purchase purchase, CarMod carMod) {
        this.quantity = quantity;
        this.purchase = purchase;
        this.carMod = carMod;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public CarMod getCarMod() {
        return carMod;
    }

    public void setCarMod(CarMod carMod) {
        this.carMod = carMod;
    }
}
