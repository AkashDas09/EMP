package com.org.EmployeManagement.EmployeManagement.in.Service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendMessageWithAttachment(String to, String subject, String text, File file) throws MessagingException {
        MimeMessage mas = emailSender.createMimeMessage();

        MimeMessageHelper ms = new MimeMessageHelper(mas, true);

        ms.setTo(to);
        ms.setSubject(subject);
        ms.setText(text);

        FileSystemResource fileResource = new FileSystemResource(file);
        ms.addAttachment(fileResource.getFilename(), fileResource);

        emailSender.send(mas);
    }
}
