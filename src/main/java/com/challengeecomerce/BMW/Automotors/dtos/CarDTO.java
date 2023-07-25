package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import java.time.LocalDate;

public class CarDTO {
    private Long id;

    private String model;

    private LocalDate date;

    private CarColor carColor;

    private Double price;

    private Boolean packM;

    public CarDTO() {
    }

    public CarDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.date = car.getDate();
        this.carColor = car.getCarColor();
        this.price = car.getPrice();
        this.packM = car.getPackM();
    }

    public String getModel() {
        return model;
    }

    public LocalDate getDate() {
        return date;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getPackM() {
        return packM;
    }
}
