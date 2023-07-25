package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import java.time.LocalDate;

public class CarDTO {
    private Long id;

    private String model;

    private LocalDate year;

    private CarColor carColor;

    private Double price;

    private Boolean packM;

    public CarDTO() {
    }

    public CarDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.year = car.getYear();
        this.carColor = car.getCarColor();
        this.price = car.getPrice();
        this.packM = car.getPackM();
    }

    public String getModel() {
        return model;
    }

    public LocalDate getYear() {
        return year;
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
