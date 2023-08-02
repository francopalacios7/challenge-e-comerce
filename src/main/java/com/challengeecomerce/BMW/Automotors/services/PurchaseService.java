package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.models.Purchase;

import java.util.List;

public interface PurchaseService {
    void save(Purchase purchase);

    Purchase findByTicketNumber(Long ticketNumber);

    Purchase findById(Long id);


}
