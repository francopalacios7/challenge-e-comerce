package com.challengeecomerce.BMW.Automotors.controllers;

import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.repositories.ClientRepository;
import com.challengeecomerce.BMW.Automotors.services.ClientService;
import com.challengeecomerce.BMW.Automotors.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmailController {
    @Autowired
    EmailService emailService;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/email")
    public ResponseEntity<?> sendAuthomaticEmail(){

        List<String> emails = emailService.emailClients();
        String[] allEmails = emails.toArray(new String[0]);

        String subject = "ASUNTO";
        String messageBody = "NO CONTESTAR AL MAIL AUTOMATICO :)";

        emailService.sendAuthomaticEmail(allEmails, subject, messageBody);

        return new ResponseEntity<>("Email sended succesfully.", HttpStatus.CREATED);
      /*  SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(allEmails);
        email.setFrom("bmwcohortfs047@hotmail.com");
        email.setSubject("Ejemplo");
        email.setText("Este es un mail enviado automaticamente, no lo respondas.");

        javaMailSender.send(email);*/


    }
}
