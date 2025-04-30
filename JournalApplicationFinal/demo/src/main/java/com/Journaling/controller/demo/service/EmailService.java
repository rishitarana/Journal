package com.Journaling.controller.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


//for checking email sent or not comment out springSecurity.

@Service
@Slf4j
public class EmailService{

    
    @Autowired
    private JavaMailSender javaMailSender;

    
    public void sendEmail(String to, String subject , String body){
        try{
            SimpleMailMessage mail=new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            mail.setFrom("rishitarana5@gmail.com");

            log.info("Sending email to: {}", to);

            javaMailSender.send(mail);
        }
        catch(Exception e){
            log.error("Exception", e);

        }
    }


    
}


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;

// import lombok.extern.slf4j.Slf4j;

// @Service
// @Slf4j
// public class EmailService {


//     @Autowired

//     private JavaMailSender  javaMailSender;


//     public void sendEmail(String to, String subject , String body){
//         try{
//             SimpleMailMessage mail=new SimpleMailMessage();
//             mail.setTo(to);
//             mail.setSubject(subject);
//             mail.setText(body);
//             javaMailSender.send(mail);
//         }
//         catch(Exception e){
//             log.error("Exception", e);
//         }
//     }






// }


// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Autowired;

// @Service
// @Slf4j
// @ComponentScan(basePackages = "com.Journaling.controller.demo.service")
// public class EmailService {

//     @Autowired
//     private JavaMailSender javaMailSender;

//     // public void sendEmail(String to, String subject, String body) {
//     //     try {
//     //         SimpleMailMessage mail = new SimpleMailMessage();
//     //         mail.setTo(to);
//     //         mail.setSubject(subject);
//     //         mail.setText(body);
//     //         javaMailSender.send(mail);
//     //         log.info("Email sent successfully to {}", to);
//     //     } catch (Exception e) {
//     //         log.error("Exception while sending email: ", e);
//     //     }
//     // }

//     public void sendEmail(String to, String subject, String body) {
//         try {
//             SimpleMailMessage mail = new SimpleMailMessage();
//             mail.setTo(to);
//             mail.setSubject(subject);
//             mail.setText(body);
//             mail.setFrom("collegeeasy5@gmail.com"); // Ensure it's set
//             javaMailSender.send(mail);
//             log.info("Email sent successfully to {}", to);
//         } catch (Exception e) {
//             log.error("Exception while sending email: ", e);
//         }
//     }
    
// }
