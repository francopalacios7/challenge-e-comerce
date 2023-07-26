package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.CarMod;
import com.challengeecomerce.BMW.Automotors.models.Mod;


public class CarModDTO {

    private Long id;
    private Double price;
    private Integer payment;
    private Car car;
    private Mod mod;
    private Long modId;

    public CarModDTO() {
    }

    public CarModDTO(CarMod carMod) {
        this.id = carMod.getId();
        this.modId = carMod.getMod().getId(); // lo agregue para poder acceder al ID del mod, como en clientLoan
        this.price = carMod.getPrice();
        this.payment = carMod.getPayment();
        this.car = carMod.getCar();
        this.mod = carMod.getMod();
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPayment() {
        return payment;
    }

    public Car getCar() {
        return car;
    }

    public Mod getMod() {
        return mod;
    }

    public Long getModId() {
        return modId;
    }
}
