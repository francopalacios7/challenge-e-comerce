package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;

@Entity
public class CarMod {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private Double price;

//     private Integer payments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Mod mod;

    public CarMod() {
    }

    public CarMod(Double price, Car car, Mod mod) {
        this.price = price;
        this.car = car;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Mod getMods() {
        return mod;
    }

    public void setMods(Mod mod) {
        this.mod = mod;
    }
}
