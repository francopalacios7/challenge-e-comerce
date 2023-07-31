package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.models.Purchase;
import com.challengeecomerce.BMW.Automotors.repositories.PurchaseRepository;
import com.challengeecomerce.BMW.Automotors.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseImplement implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Override
    public void save(Purchase purchase) { purchaseRepository.save(purchase);}

    @Override
    public Purchase findByTicketNumber(Long ticketNumber) {
        return purchaseRepository.findByTicketNumber(ticketNumber);
    }


}
