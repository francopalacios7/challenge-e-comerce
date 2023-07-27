package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.CarMod;
import com.challengeecomerce.BMW.Automotors.models.CarPurchase;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CarDTO {
    private Long id;

    private String model;

    private LocalDate date;

    private CarColor carColor;

    private Double price;

    private Boolean packM;

    private Integer stock;

    //private Set<CarPurchaseDTO> carPurchaseDTOS;

    private Set<CarModDTO> carModDTO;

    public CarDTO() {
    }

    public CarDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.date = car.getDate();
        this.carColor = car.getCarColor();
        this.price = car.getPrice();
        this.packM = car.getPackM();
        this.stock = car.getStock();
//        this.carPurchaseDTOS = car.getCarPurchaseSet()
//                .stream()
//                .map(carPurchase -> new CarPurchaseDTO(carPurchase))
//                .collect(Collectors.toSet());
        this.carModDTO = car.getCarModSet()
                .stream()
                .map(carMod -> new CarModDTO(carMod))
                .collect(Collectors.toSet());;
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

    public Integer getStock() {
        return stock;
    }

//    public Set<CarPurchaseDTO> getCarPurchaseDTOS() {
//        return carPurchaseDTOS;
//    }

    public Set<CarModDTO> getCarModDTO() {
        return carModDTO;
    }
}
