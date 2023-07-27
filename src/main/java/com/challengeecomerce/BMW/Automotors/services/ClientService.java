package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.models.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    Client findByEmail(String email);
    void save(Client client);
}
