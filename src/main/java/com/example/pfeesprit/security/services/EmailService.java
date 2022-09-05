package com.example.pfeesprit.security.services;


import org.springframework.mail.SimpleMailMessage;
public interface EmailService {
public void sendEmail(SimpleMailMessage email);
}