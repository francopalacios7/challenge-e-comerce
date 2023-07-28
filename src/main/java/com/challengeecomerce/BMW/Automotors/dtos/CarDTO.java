package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.CarMod;
import com.challengeecomerce.BMW.Automotors.models.CarPurchase;
import com.challengeecomerce.BMW.Automotors.models.enums.CarColor;
import com.challengeecomerce.BMW.Automotors.models.enums.ModType;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarDTO {
    private Long id;
    private String model;
    private LocalDate date;
    private CarColor carColor;
    private Double price;
    private List<Integer> payments;
    private Boolean packM;
    private Integer stock;
    //private Set<CarPurchaseDTO> carPurchaseDTOS;
    private List<String> images;
    private List<ModType> modType;
    public CarDTO() {}
////        this.carPurchaseDTOS = car.getCarPurchaseSet()
////                .stream()
////                .map(carPurchase -> new CarPurchaseDTO(carPurchase))
////                .collect(Collectors.toSet());
//        this.modType = car.getModType()
//                .stream()
//                .map(modType -> new ModDTO(modType))
//                .collect(Collectors.toSet());;
    public CarDTO(Car car) {
        this.model = car.getModel();
        this.date = car.getDate();
        this.carColor = car.getCarColor();
        this.price = car.getPrice();
        this.payments = car.getPayments();
        this.packM = car.getPackM();
        this.stock = car.getStock();
        this.images = car.getImages();
        this.modType = car.getModType();
    }
    public String getModel() {return model;}
    public LocalDate getDate() {return date;}
    public CarColor getCarColor() {return carColor;}
    public Double getPrice() {return price;}
    public List<Integer> getPayments() {return payments;}
    public Boolean getPackM() {return packM;}
    public Integer getStock() {return stock;}
//    public Set<CarPurchaseDTO> getCarPurchaseDTOS() {
//        return carPurchaseDTOS;
//    }
    public Long getId() {return id;}
    public List<String> getImages() {return images;}
    public List<ModType> getModType() {return modType;}
}