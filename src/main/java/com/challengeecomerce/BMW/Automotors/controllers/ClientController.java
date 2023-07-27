package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.ClientDTO;
import com.challengeecomerce.BMW.Automotors.dtos.PurchaseDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/clients")
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClients();
    }
    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName,
                                           @RequestParam String email, @RequestParam String address,
                                           @RequestParam String phone, @RequestParam String password){
        if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || address.isBlank() || phone.isBlank() || password.isBlank()){
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN); //ACOMODAR
        }
        if (clientService.findByEmail(email) != null){
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }
        Client client = new Client(firstName, lastName, email, passwordEncoder.encode(password), address, phone);
        clientService.save(client);
        return new ResponseEntity<>("Registered with success", HttpStatus.CREATED);
    }

    @PostMapping("/clients/purchase")
    public ResponseEntity<Object> purchase(@RequestBody PurchaseDTO purchaseDTO, Authentication authentication){

        Client client = clientService.findByEmail(authentication.getName());

        if(client == null){
            return new ResponseEntity<>("The client is invalid. Please, try again.", HttpStatus.FORBIDDEN);
        }
        if (purchaseDTO.getTotalAmount().isNaN()){
            return new ResponseEntity<>("The amount cannot be blank. Please, try again.", HttpStatus.FORBIDDEN);
        }
        if(purchaseDTO.getDate().toString().isBlank()){
            return new ResponseEntity<>("The date cannot be blank. Please, try again.", HttpStatus.FORBIDDEN);
        }
        if(purchaseDTO.getPayments().isEmpty()){
            return new ResponseEntity<>("The payments cannot be blank. Please, try again.", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>("Purchase successful.", HttpStatus.ACCEPTED);
    }
}