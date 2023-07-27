package com.challengeecomerce.BMW.Automotors.services;

import com.challengeecomerce.BMW.Automotors.dtos.ClientDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;

import java.util.List;

public interface ClientService {
    Client findByEmail(String email);
    void save(Client client);
    List<ClientDTO> getAllClients();
}
