package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.dtos.ClientDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.repositories.ClientRepository;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientImplement implements ClientService{
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client findByEmail(String email) {return clientRepository.findByEmail(email);}
    @Override
    public void save(Client client) {clientRepository.save(client);}

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientDTO::new)
                .collect(Collectors.toList());
    }

}
