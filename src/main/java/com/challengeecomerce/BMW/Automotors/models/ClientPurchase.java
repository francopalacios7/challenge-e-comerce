package com.challengeecomerce.BMW.Automotors.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ClientPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @OneToMany(mappedBy = "purchase", fetch= FetchType.EAGER)
    private Set<Purchase> purchaseSet = new HashSet<>();

    public ClientPurchase() {
    }

    public ClientPurchase(Double totalAmount, Client client, Set<Purchase> purchaseSet) {
        this.totalAmount = totalAmount;
        this.client = client;
        this.purchaseSet = purchaseSet;
    }


    public Long getId() {
        return id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Purchase> getPurchaseSet() {
        return purchaseSet;
    }

    public void setPurchaseSet(Set<Purchase> purchaseSet) {
        this.purchaseSet = purchaseSet;
    }
}
