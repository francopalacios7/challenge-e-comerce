package com.challengeecomerce.BMW.Automotors.models;

import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Mod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private CarColor carColor;

    private Integer stock;

    @OneToMany(mappedBy = "mod", fetch = FetchType.EAGER)
    private Set<ModPurchase> modPurchaseSet = new HashSet<>();
    @OneToMany(mappedBy = "mod", fetch = FetchType.EAGER)
    private Set<CarModDos> carModDosSet = new HashSet<>();

    public Mod() {
    }

    public Mod(String name, Double price, CarColor carColor, Integer stock, Set<ModPurchase> modPurchaseSet, Set<CarModDos> carModDosSet) {
        this.name = name;
        this.price = price;
        this.carColor = carColor;
        this.stock = stock;
        this.modPurchaseSet = modPurchaseSet;
        this.carModDosSet = carModDosSet;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Set<ModPurchase> getModPurchaseSet() {
        return modPurchaseSet;
    }

    public void setModPurchaseSet(Set<ModPurchase> modPurchaseSet) {
        this.modPurchaseSet = modPurchaseSet;
    }

    public Set<CarModDos> getCarModDosSet() {
        return carModDosSet;
    }

    public void setCarModDosSet(Set<CarModDos> carModDosSet) {
        this.carModDosSet = carModDosSet;
    }
}
