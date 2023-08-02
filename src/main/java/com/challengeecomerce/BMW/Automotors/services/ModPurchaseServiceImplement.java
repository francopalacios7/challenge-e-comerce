package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.models.ModPurchase;
import com.challengeecomerce.BMW.Automotors.repositories.ModPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModPurchaseServiceImplement implements ModPurchaseService{

    @Autowired
    private ModPurchaseRepository modPurchaseRepository;
    @Override
    public ModPurchase findById(Long id) {
        return modPurchaseRepository.findById(id).orElse(null);
    }
}
