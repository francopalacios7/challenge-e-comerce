package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CarMod {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private Double price;

     private Integer payments;

    // private Integer stock;

//     @OneToMany(mappedBy = "carMod", fetch = FetchType.EAGER)
//     private Set<CarModPurchase> carModPurchaseSet = new HashSet<>();
//
//     @OneToMany(mappedBy = "carMod", fetch = FetchType.EAGER)
//     private Set<CarModDos> carModDosSet = new HashSet<>();

     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "car_id")
     private Car car;

     public CarMod() {
     }

    public CarMod(Double price, Integer payments, Set<CarModPurchase> carModPurchaseSet, Set<CarModDos> carModDosSet, Integer stock, Car car) {
        this.price = price;
        this.payments = payments;
        this.car = car;
        // this.stock = stock;
//        this.carModPurchaseSet = carModPurchaseSet;
//        this.carModDosSet = carModDosSet;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPayment() {
        return payments;
    }

    public void setPayment(Integer payment) {
        this.payments = payment;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

//    public Set<CarModPurchase> getCarModPurchaseSet() {
//        return carModPurchaseSet;
//    }
//
//    public void setCarModPurchaseSet(Set<CarModPurchase> carModPurchaseSet) {
//        this.carModPurchaseSet = carModPurchaseSet;
//    }

//    public Set<CarModDos> getCarModDosSet() {
//        return carModDosSet;
//    }
//
//    public void setCarModDosSet(Set<CarModDos> carModDosSet) {
//        this.carModDosSet = carModDosSet;
//    }

//    public Integer getStock() {
//        return stock;
//    }
//
//    public void setStock(Integer stock) {
//        this.stock = stock;
//    }


}
