package com.challengeecomerce.BMW.Automotors.services.implement;

import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.repositories.ClientRepository;
import com.challengeecomerce.BMW.Automotors.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImplement implements EmailService {

    @Autowired
    private ClientRepository clientRepository;
    private final JavaMailSender emailSender;

    public EmailServiceImplement(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    @Override
    public List<String> emailClients() {
        return clientRepository.findAll().stream().map(Client::getEmail).collect(Collectors.toList());
    }
    @Override
    public void sendAuthomaticEmail(String[] emails, String subject, String messageBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        for (String email : emails) {
            message.setTo(email);
            message.setFrom("bmwcohortfs047@hotmail.com");
            message.setSubject(subject);
            message.setText(messageBody);
            emailSender.send(message);
        }
    }

    @Override
    public void sendAuthomaticEmailWithAttachment(String[] emails, String subject, String messageBody, byte[] fileBytes) {
        for (String email : emails) {
            MimeMessage message = emailSender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setTo(email);
                helper.setFrom("bmwcohortfs047@hotmail.com");
                helper.setSubject(subject);
                helper.setText(messageBody);
                // Adjuntar el archivo al correo electrónico
                ByteArrayDataSource dataSource = new ByteArrayDataSource(fileBytes, "application/octet-stream");
                helper.addAttachment("foto", dataSource); // Reemplaza "filename.ext" con el nombre deseado para el archivo adjunto
                emailSender.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

}

