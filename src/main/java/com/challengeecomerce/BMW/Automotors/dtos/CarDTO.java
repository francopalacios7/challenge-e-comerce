package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.CarType;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import java.time.Year;
import java.util.List;

public class CarDTO {
    private Long id;
    private String details;
    private CarType carType;
    private String model;
    private Year date;
    private CarColor carColor;
    private Double price;
    private String description;
    private List<Integer> payments;
    private Boolean packM;
    private Integer stock;
    private List<String> images;
    private List<ModType> modType;
    private Boolean active;
    public CarDTO() {}
    public CarDTO(Car car) {
        this.id = car.getId();
        this.details = car.getDetails();
        this.model = car.getModel();
        this.date = car.getDate();
        this.carColor = car.getCarColor();
        this.price = car.getPrice();
        this.description = car.getDescription();
        this.payments = car.getPayments();
        this.packM = car.getPackM();
        this.carType = car.getCarType();
        this.stock = car.getStock();
        this.images =car.getImages();
        this.modType =car.getModType();
        this.active= car.getActive();
    }

    public Long getId() {return id;}

    public String getDetails() {
        return details;
    }

    public String getModel() {
        return model;
    }
    public Year getDate() {return date;}
    public CarColor getCarColor() {
        return carColor;
    }
    public Double getPrice() {
        return price;
    }
    public Boolean getPackM() {
        return packM;
    }
    public CarType getCarType() {return carType;}
    public Integer getStock() {
        return stock;
    }

    public List<Integer> getPayments() {return payments;}

    public String getDescription() {
        return description;
    }

    public List<String> getImages() {return images;}
    public List<ModType> getModType() {return modType;}

    public Boolean getActive() {
        return active;
    }
}
