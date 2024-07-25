package com.org.EmployeManagement.EmployeManagement.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.EmployeManagement.EmployeManagement.in.Service.EmailService;
import com.org.EmployeManagement.EmployeManagement.in.Service.EmployeService;

import jakarta.mail.MessagingException;

import java.io.File;
import java.io.IOException;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;
    @PostMapping("/send-emails")
    public String sendEmail(@RequestParam("to") String to,
                            @RequestParam("subject") String subject,
                            @RequestParam("text") String text,
                            @RequestParam("file") MultipartFile file,
                            Model model) {
        try {
            // Save the uploaded file to a temporary location
            File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile);

            // Send the email with attachment
            emailService.sendMessageWithAttachment(to, subject, text, tempFile);

            // Delete the temporary file
            tempFile.delete();

            model.addAttribute("messagedone", "Email sent successfully");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            model.addAttribute("messagenotdone", "Error sending email: " + e.getMessage());
        }
        return "sendmail";
    }
}

