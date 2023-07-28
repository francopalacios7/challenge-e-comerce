package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.CarType;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;
import java.time.LocalDate;
import java.util.List;

public class CarDTO {
    private Long id;
    private CarType carType;
    private String model;
    private LocalDate date;
    private CarColor carColor;
    private Double price;
    private List<Integer> payments;
    private Boolean packM;
    private Integer stock;
    private List<String> images;
    private List<ModType> modType;
    public CarDTO() {}
    public CarDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.date = car.getDate();
        this.carColor = car.getCarColor();
        this.price = car.getPrice();
        this.payments = car.getPayments();
        this.packM = car.getPackM();
        this.stock = car.getStock();
        this.carType = car.getCarType();
        this.images =car.getImages();
        this.modType =car.getModType();
    }
    public String getModel() {
        return model;
    }
    public LocalDate getDate() {return date;}
    public CarColor getCarColor() {
        return carColor;
    }
    public Double getPrice() {
        return price;
    }
    public Boolean getPackM() {
        return packM;
    }
    public Integer getStock() {
        return stock;
    }
    public CarType getCarType() {return carType;}
    public List<Integer> getPayments() {return payments;}
    public Long getId() {return id;}
    public List<String> getImages() {return images;}
    public List<ModType> getModType() {return modType;}
}
