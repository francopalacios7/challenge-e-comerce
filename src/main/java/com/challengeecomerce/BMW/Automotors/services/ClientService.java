package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.models.Client;

public interface ClientService {
    Client findByEmail(String email);
    void save(Client client);
}
