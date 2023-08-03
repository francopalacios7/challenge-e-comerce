package com.challengeecomerce.BMW.Automotors.dtos;
import com.challengeecomerce.BMW.Automotors.models.ClientPurchase;

import java.time.LocalDate;

public class ClientPurchaseDTO {

    private Long id;

    private Double totalAmount;

    private LocalDate creationDate;

    public ClientPurchaseDTO() {
    }

    public ClientPurchaseDTO(ClientPurchase clientPurchase) {
        this.totalAmount = clientPurchase.getTotalAmount();
        this.creationDate = LocalDate.now();

    }


    public Long getId() {
        return id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }



}
