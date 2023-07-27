package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Purchase;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PurchaseDTO {
    private Long id;
    private LocalDate date;
    private Double totalAmount;
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
                .map(CarDTO::new)
                .collect(Collectors.toSet());
        this.modSet = purchase.getModsSet()
                .stream()
                .map(ModDTO::new)
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
    public Set<CarDTO> getCarSet() {
        return carSet;
    }
    public Set<ModDTO> getModSet() {
        return modSet;
    }
}
