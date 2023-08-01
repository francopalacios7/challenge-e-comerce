package com.challengeecomerce.BMW.Automotors.services.implement;
import com.challengeecomerce.BMW.Automotors.models.ClientPurchase;
import com.challengeecomerce.BMW.Automotors.repositories.ClientPurchaseRepository;
import com.challengeecomerce.BMW.Automotors.services.ClientPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientPurchaseServiceImplement implements ClientPurchaseService {

    @Autowired
    private ClientPurchaseRepository clientPurchaseRepository;

    @Override
    public void saveClientPurchase(ClientPurchase clientPurchase) {
        clientPurchaseRepository.save(clientPurchase);
    }
}
