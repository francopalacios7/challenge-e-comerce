package com.challengeecomerce.BMW.Automotors.services;

import java.util.List;

public interface EmailService {
    void sendAuthomaticEmail(String[] emails, String subject, String messageBody);
    List<String> emailClients();
}
