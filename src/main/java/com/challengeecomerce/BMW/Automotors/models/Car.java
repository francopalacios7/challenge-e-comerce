package com.challengeecomerce.BMW.Automotors.models;

import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private LocalDate date;

    private CarColor carColor;

    private Double price;

    private Boolean packM;

   @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
   private Set<CarPurchase> carPurchaseSet = new HashSet<>();
    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private Set<CarMod> carModSet = new HashSet<>();

    public Car() {
    }

    public Car(String model, LocalDate date, CarColor carColor, Double price, Boolean packM, Set<CarPurchase> carPurchaseSet, Set<CarMod> carModSet) {
        this.model = model;
        this.date = date;
        this.carColor = carColor;
        this.price = price;
        this.packM = packM;
        this.carPurchaseSet = carPurchaseSet;
        this.carModSet = carModSet;
    }

    public Long getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPackM() {
        return packM;
    }

    public void setPackM(Boolean packM) {
        this.packM = packM;
    }

    public Set<CarPurchase> getCarPurchaseSet() {
        return carPurchaseSet;
    }

    public void setCarPurchaseSet(Set<CarPurchase> carPurchaseSet) {
        this.carPurchaseSet = carPurchaseSet;
    }

    public Set<CarMod> getCarModSet() {
        return carModSet;
    }

    public void setCarModSet(Set<CarMod> carModSet) {
        this.carModSet = carModSet;
    }
}
