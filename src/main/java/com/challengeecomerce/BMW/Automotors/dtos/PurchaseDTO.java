package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Car;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.Mod;
import com.challengeecomerce.BMW.Automotors.models.Purchase;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PurchaseDTO {
    private Long id;
    private LocalDate date;
    private double totalAmount;
    private List<Integer> payments;
    private Set<CarDTO> carSet;
    private Set<ModDTO> modSet;
    public PurchaseDTO() {
    }

    public PurchaseDTO(Purchase purchase) {
        this.id = purchase.getId();
        this.date = purchase.getDate();
        this.totalAmount = purchase.getTotalAmount();
        this.payments = purchase.getPayments();
        this.carSet = purchase.getCarSet()
                .stream()
                .map(car -> new CarDTO(car))
                .collect(Collectors.toSet());
        this.modSet = purchase.getModsSet()
                .stream()
                .map(mod -> new ModDTO(mod))
                .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Integer> getPayments() {
        return payments;
    }


    public Set<CarDTO> getCarSet() {
        return carSet;
    }

    public Set<ModDTO> getModSet() {
        return modSet;
    }
}
