package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.dtos.ClientDTO;
import com.challengeecomerce.BMW.Automotors.dtos.PurchaseDTO;
import com.challengeecomerce.BMW.Automotors.dtos.MeetingReservationDTO;
import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.models.ClientPurchase;
import com.challengeecomerce.BMW.Automotors.models.Purchase;
import com.challengeecomerce.BMW.Automotors.models.enums.PurchaseType;
import com.challengeecomerce.BMW.Automotors.services.CarService;
import com.challengeecomerce.BMW.Automotors.services.ClientPurchaseService;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDate;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CarService carService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientPurchaseService clientPurchaseService;
    @Autowired
    private JavaMailSender javaMailSender;
    @GetMapping("/clients/current")
    public ClientDTO getAuthenticatedClient(Authentication authentication) {
        return new ClientDTO(clientService.findByEmail(authentication.getName()));
    }
    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestBody ClientDTO clientDTO) {
        if (clientDTO.getEmail().isBlank()) {
            return new ResponseEntity<>("The email cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getPassword().isBlank()) {
            return new ResponseEntity<>("The password cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getLastName().isBlank()) {
            return new ResponseEntity<>("The last name cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getFirstName().isBlank()) {
            return new ResponseEntity<>("The first name cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getPhone().isBlank()) {
            return new ResponseEntity<>("The phone cannot be blank.", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getAddress().isBlank()) {
            return new ResponseEntity<>("The address cannot be blank.", HttpStatus.FORBIDDEN);
        }
        Client client = new Client(clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail(), passwordEncoder.encode(clientDTO.getPassword()), clientDTO.getAddress(), clientDTO.getPhone());
        clientService.save(client);
        return new ResponseEntity<>("Registered with success", HttpStatus.CREATED);
    }
    @GetMapping("/clients")
    public List<ClientDTO> getAllClients(){
        return clientService.getAllClients();
    }
    @PostMapping("/clients/purchase")
    public ResponseEntity<Object> purchase(@RequestBody PurchaseDTO purchaseDTO, Authentication authentication) {
        Client client = clientService.findByEmail(authentication.getName());
        if (client == null) {
            return new ResponseEntity<>("The client is invalid. Please, try again.", HttpStatus.FORBIDDEN);
        }
        if (purchaseDTO.getTotalAmount().isNaN()) {
            return new ResponseEntity<>("The amount cannot be blank. Please, try again.", HttpStatus.FORBIDDEN);
        }
        if (purchaseDTO.getPayments().toString().isBlank()) {
            return new ResponseEntity<>("The payments cannot be blank. Please, try again.", HttpStatus.FORBIDDEN);
        }
        if (purchaseDTO.getPurchaseType().equals(PurchaseType.CAR) || purchaseDTO.getPurchaseType().equals(PurchaseType.MOD)) {

            Random random = new Random();
            Long ticketNumber;
            do {
                ticketNumber = random.nextLong();
            } while (purchaseService.findByTicketNumber(ticketNumber) != null);

            Purchase purchase = new Purchase(ticketNumber, LocalDate.now(), purchaseDTO.getTotalAmount(), purchaseDTO.getPayments(), purchaseDTO.getPurchaseType());
            ClientPurchase clientPurchase = new ClientPurchase(purchaseDTO.getTotalAmount());

            purchaseService.save(purchase);
            client.addClientPurchase(clientPurchase);
            clientService.save(client);
            clientPurchaseService.save(clientPurchase);
        }
        return new ResponseEntity<>(purchaseDTO.getPurchaseType() + " " + "purchase successful", HttpStatus.ACCEPTED);
    }
    @PostMapping("/client/sendEmail")
    public ResponseEntity<?> turnReservation(Authentication authentication, @RequestBody MeetingReservationDTO turnReservationDTO) {
        Client client = clientService.findByEmail(authentication.getName());
        if (client == null) {
            return new ResponseEntity<>("The client is invalid. Please, try again.", HttpStatus.FORBIDDEN);
        }
        String emailToSend = turnReservationDTO.getEmail();
        LocalDateTime turn = turnReservationDTO.getMeetingReservation();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = turn.format(formatter);
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailToSend);
        email.setFrom("bmwcohortfs047@hotmail.com");
        email.setSubject("Turn Reservation");
        email.setText("You have a shift reservation for the day " + formattedDateTime);
        javaMailSender.send(email);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}