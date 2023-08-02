package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.models.Purchase;

public interface PurchaseService {
    void save(Purchase purchase);

    Purchase findByTicketNumber(Long ticketNumber);

    Purchase findById(Long id);


}
