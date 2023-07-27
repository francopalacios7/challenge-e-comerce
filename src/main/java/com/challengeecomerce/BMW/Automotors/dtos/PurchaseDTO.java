package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.*;
import com.challengeecomerce.BMW.Automotors.models.enums.PurchaseType;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PurchaseDTO {
    private Long id;
    private LocalDate date;
    private Double totalAmount;
    private PurchaseType purchaseType;
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
        this.purchaseType = purchase.getPurchaseType();
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
    public PurchaseType getPurchaseType() {return purchaseType;}
    public Set<CarModPurchaseDTO> getCarModPurchaseDTO() {
        return carModPurchaseDTO;
    }
}
