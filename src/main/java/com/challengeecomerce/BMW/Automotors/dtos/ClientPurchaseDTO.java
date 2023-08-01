package com.challengeecomerce.BMW.Automotors.dtos;

import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.ClientPurchase;
import com.challengeecomerce.BMW.Automotors.models.Purchase;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ClientPurchaseDTO {

    private Long id;

    private Double totalAmount;

    private Client client;
    private LocalDate creationDate;

    private Set<Purchase> purchaseSet = new HashSet<>();

    public ClientPurchaseDTO() {
    }

    public ClientPurchaseDTO(ClientPurchase clientPurchase) {
        this.totalAmount = clientPurchase.getTotalAmount();
        this.creationDate = clientPurchase.getCreationDate();
    }


    public Long getId() {
        return id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Client getClient() {
        return client;
    }

    public Set<Purchase> getPurchaseSet() {
        return purchaseSet;
    }
}
