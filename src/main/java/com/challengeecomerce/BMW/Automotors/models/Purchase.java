package com.challengeecomerce.BMW.Automotors.models;

import com.challengeecomerce.BMW.Automotors.models.enums.PurchaseType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ticketNumber;
    private LocalDate date;
    private Double totalAmount;
    private PurchaseType purchaseType;
    private Integer payments;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientPurchase_id")
    private ClientPurchase clientPurchase;
    @OneToMany(mappedBy = "purchase",fetch = FetchType.EAGER)
    private Set<ModPurchase> modPurchaseSet = new HashSet<>();
    @OneToOne(mappedBy = "purchase",fetch = FetchType.EAGER)
    private DuesPlan duesPlan;
    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    private Set<PurchaseDuesPlan> purchaseDuesPlans = new HashSet<>();

    public Purchase() {
    }

    public Purchase(Long ticketNumber,LocalDate date, Double totalAmount, Integer payments, PurchaseType type) {
        this.ticketNumber = ticketNumber;
        this.date = date;
        this.totalAmount = totalAmount;
        this.payments = payments;
        this.purchaseType = type;
        this.duesPlan = duesPlan;
    }
    public Long getId() {
        return id;
    }
    public Long getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {this.date = date;}
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Integer getPayments() {
        return payments;
    }
    public void setPayments(Integer payments) {
        this.payments = payments;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public PurchaseType getPurchaseType() {return purchaseType;}
    public void setPurchaseType(PurchaseType purchaseType) {this.purchaseType = purchaseType;}
    public ClientPurchase getClientPurchase() {return clientPurchase;}
    public void setClientPurchase(ClientPurchase clientPurchase) {this.clientPurchase = clientPurchase;}
    public Set<ModPurchase> getModPurchaseSet() {return modPurchaseSet;}
    public void setModPurchaseSet(Set<ModPurchase> modPurchaseSet) {this.modPurchaseSet = modPurchaseSet;}

    public Set<PurchaseDuesPlan> getPurchaseDuesPlans() { return purchaseDuesPlans; }

    public void setPurchaseDuesPlans(Set<PurchaseDuesPlan> purchaseDuesPlans) { this.purchaseDuesPlans = purchaseDuesPlans; }

    public void addModPurchaseSet(ModPurchase modPurchase){
        modPurchase.setPurchase(this);
        this.modPurchaseSet.add(modPurchase);
    }

    public void addPurchaseDuesPlan(PurchaseDuesPlan purchaseDuesPlan){
        purchaseDuesPlan.setPurchase(this);
        this.purchaseDuesPlans.add(purchaseDuesPlan);
    }
}

