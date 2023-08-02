package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.models.ClientPurchase;
import com.challengeecomerce.BMW.Automotors.repositories.ClientPurchaseRepository;
import com.challengeecomerce.BMW.Automotors.services.ClientPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientPurchaseImplement implements ClientPurchaseService {
    @Autowired
    ClientPurchaseRepository clientPurchaseRepository;
    @Override
    public void save(ClientPurchase clientPurchase) {
        clientPurchaseRepository.save(clientPurchase);
    }

    @Override
    public ClientPurchase findById(Long id) {
        return clientPurchaseRepository.findById(id).orElse(null);
    }
}
