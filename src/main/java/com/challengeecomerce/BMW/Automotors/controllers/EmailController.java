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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ResponseEntity<?> sendAuthomaticEmail(@RequestParam("header") String header,
                                                 @RequestParam("message") String message,
                                                 @RequestParam("file") MultipartFile file){

        List<String> emails = emailService.emailClients();
        String[] allEmails = emails.toArray(new String[0]);

        String subject = header;
        String messageBody = message;

        try {
            byte[] fileBytes = file.getBytes();
            String fileName = file.getOriginalFilename();

            emailService.sendAuthomaticEmailWithAttachment(allEmails, subject, messageBody, fileBytes);

            return new ResponseEntity<>("Email sent successfully.", HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Error sending email.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}