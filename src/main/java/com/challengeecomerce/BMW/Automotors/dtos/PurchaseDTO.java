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
    private Integer payments;
    private Set<ModPurchaseDTO> modPurchaseDTO;

    private DuesPlan duesPlan;
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
    public Integer getPayments() {
        return payments;
    }
    public Set<ModPurchaseDTO> getModPurchaseDTO() {
        return modPurchaseDTO;
    }
    public PurchaseType getPurchaseType() {return purchaseType;}
    public DuesPlan getDuesPlan() {return duesPlan;}
}
