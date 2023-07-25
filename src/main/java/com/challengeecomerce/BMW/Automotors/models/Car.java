package com.challengeecomerce.BMW.Automotors.models;

import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private LocalDate year;

    private CarColor carColor;

    private Double price;

    private Boolean packM;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "purchase_id")
    private Purchase purchase;

    public Car() {
    }

    public Car(String model, LocalDate year, CarColor carColor, Double price, Boolean packM, Purchase purchase) {
        this.model = model;
        this.year = year;
        this.carColor = carColor;
        this.price = price;
        this.packM = packM;
        this.purchase = purchase;
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

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
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

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
