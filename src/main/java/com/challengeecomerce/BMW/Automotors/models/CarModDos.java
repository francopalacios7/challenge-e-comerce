package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;

@Entity
public class CarModDos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private Integer payments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carMod_id")
    private CarMod carMod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mod_id")
    private Mod mod;

    public CarModDos() {
    }

    public CarModDos(Double price, Integer payments, CarMod carMod, Mod mod) {
        this.price = price;
        this.payments = payments;
        this.carMod = carMod;
        this.mod = mod;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public CarMod getCarMod() {
        return carMod;
    }

    public void setCarMod(CarMod carMod) {
        this.carMod = carMod;
    }

    public Mod getMod() {
        return mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }
}
