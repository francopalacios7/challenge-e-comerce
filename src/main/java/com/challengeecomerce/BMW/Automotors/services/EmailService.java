package com.challengeecomerce.BMW.Automotors.services;

import java.util.List;

public interface EmailService {
    void sendAuthomaticEmail(String[] emails, String subject, String messageBody);

    void sendAuthomaticEmailWithAttachment(String[] emails, String subject, String messageBody,byte[] fileBytes);
    List<String> emailClients();
}
