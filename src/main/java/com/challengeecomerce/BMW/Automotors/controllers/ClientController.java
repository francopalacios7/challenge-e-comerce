package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.ClientDTO;
import com.challengeecomerce.BMW.Automotors.dtos.PurchaseDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.Purchase;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestBody ClientDTO clientDTO){
        if (clientDTO.getEmail().isBlank()){
            return new ResponseEntity<>("The email cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getPassword().isBlank()){
            return new ResponseEntity<>("The password cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getLastName().isBlank()){
            return new ResponseEntity<>("The last name cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getFirstName().isBlank()){
            return new ResponseEntity<>("The first name cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getPhone().isBlank()){
            return new ResponseEntity<>("The phone cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getAddress().isBlank()){
            return new ResponseEntity<>("The address cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientService.findByEmail(clientDTO.getEmail()) != null){
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }
        Client client = new Client(clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail(), clientDTO.getPassword(), clientDTO.getAddress(), clientDTO.getPhone());
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
        if (purchaseDTO.getPurchaseType().equals("CAR")){
            Purchase purchase = new Purchase(purchaseDTO.getDate(), purchaseDTO.getTotalAmount(), purchaseDTO.getPayments(), purchaseDTO.getPurchaseType());
            return new ResponseEntity<>("Purchase successful", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("Purchase successful.", HttpStatus.ACCEPTED);
    }
}