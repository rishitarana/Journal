// package com.Journaling.controller.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.Journaling.controller.demo.service.EmailService;

// @RestController
// public class EmailController {

//     @Autowired
//     private EmailService emailService;

//     @GetMapping("/send-email")
//     public String sendEmail(@RequestParam String to) {
//         emailService.sendEmail(to, "Test Subject", "This is a test email body.");
//         return "Email sent if no errors occurred.";
//     }
// }
