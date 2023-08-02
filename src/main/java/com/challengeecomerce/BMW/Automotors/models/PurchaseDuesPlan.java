package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseDuesPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate purchaseCreation;
    private Integer purchaseDuesPlanQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "purchase_id")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "duesPlan_id")
    private DuesPlan duesPlan;


    public PurchaseDuesPlan() {
    }

    public PurchaseDuesPlan(LocalDate purchaseCreation, Integer purchaseDuesPlanQuantity) {
        this.purchaseCreation = purchaseCreation;
        this.purchaseDuesPlanQuantity = purchaseDuesPlanQuantity;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getPurchaseCreation() { return purchaseCreation; }

    public void setPurchaseCreation(LocalDate purchaseCreation) { this.purchaseCreation = purchaseCreation; }

    public Integer getPurchaseDuesPlanQuantity() { return purchaseDuesPlanQuantity; }

    public void setPurchaseDuesPlanQuantity(Integer purchaseDuesPlanQuantity) { this.purchaseDuesPlanQuantity = purchaseDuesPlanQuantity; }

    public Purchase getPurchase() { return purchase; }

    public void setPurchase(Purchase purchase) { this.purchase = purchase; }

    public DuesPlan getDuesPlan() { return duesPlan; }

    public void setDuesPlan(DuesPlan duesPlan) { this.duesPlan = duesPlan; }
}

