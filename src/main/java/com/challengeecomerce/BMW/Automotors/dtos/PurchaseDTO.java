package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PurchaseDTO {
    private Long id;
    private LocalDate date;
    private Double totalAmount;

    private List<Integer> payments;

    private Set<CarPurchaseDTO> carPurchaseDTO;

    private Set<ModPurchaseDTO> modPurchaseDTO;

    private Set<CarModPurchaseDTO> carModPurchaseDTO;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Purchase purchase) {
        this.id = purchase.getId();
        this.date = purchase.getDate();
        this.totalAmount = purchase.getTotalAmount();
        this.payments = purchase.getPayments();
        this.carPurchaseDTO = purchase.getCarPurchaseSet()
                .stream()
                .map(CarPurchaseDTO::new)
                .collect(Collectors.toSet());
        this.modPurchaseDTO = purchase.getModPurchaseSet() .stream()
                .map(ModPurchaseDTO::new)
                .collect(Collectors.toSet());
        this.carModPurchaseDTO = purchase.getCarModPurchaseSet()
                .stream()
                .map(CarModPurchaseDTO::new)
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public Set<CarPurchaseDTO> getCarPurchaseDTO() {
        return carPurchaseDTO;
    }

    public Set<ModPurchaseDTO> getModPurchaseDTO() {
        return modPurchaseDTO;
    }

    public Set<CarModPurchaseDTO> getCarModPurchaseDTO() {
        return carModPurchaseDTO;
    }
}
