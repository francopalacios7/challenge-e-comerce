package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;

@Entity
public class CarMod {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private Double price;
     private Integer payments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Mod mod;

    public CarMod() {
    }

    public CarMod(Double price, Integer payment, Car car, Mod mod) {
        this.price = price;
        this.payments = payment;
        this.car = car;
        this.mod = mod;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPayment() {
        return payments;
    }

    public void setPayment(Integer payment) {
        this.payments = payment;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Mod getMod() {
        return mod;
    }

    public void setMod(Mod mod) {
        this.mod = mod;
    }
}
