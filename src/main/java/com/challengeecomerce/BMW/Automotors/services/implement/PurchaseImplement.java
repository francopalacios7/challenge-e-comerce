package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.dtos.DuesPlanDTO;
import com.challengeecomerce.BMW.Automotors.models.Purchase;
import com.challengeecomerce.BMW.Automotors.repositories.DuesPlanRepository;
import com.challengeecomerce.BMW.Automotors.repositories.PurchaseRepository;
import com.challengeecomerce.BMW.Automotors.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseImplement implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private DuesPlanRepository duesPlanRepository;
    @Override
    public void save(Purchase purchase) { purchaseRepository.save(purchase);}

    @Override
    public Purchase findByTicketNumber(Long ticketNumber) {
        return purchaseRepository.findByTicketNumber(ticketNumber);
    }

    @Override
    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }




}
