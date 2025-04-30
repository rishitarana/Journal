package com.Journaling.controller.demo.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class EmailServiceTests{

    
    @Autowired
    private EmailService emailService;

    @Disabled
    @Test
    void testSendMail(){
        
        emailService.sendEmail("rishitarana2003@gmail.com", "Testing java mail sender", "hi how are you");
        
    }

}

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;

// import com.Journaling.controller.demo.service.EmailService;

// public class EmailServiceTests {

//     @Autowired
//     private EmailService emailService;

//     @Test
//     void testSendMail(){
//         // emailService.sendEmail("collegeeasy5@gamil.com", "Testing java mail sender", "hi how are you");
//         emailService.sendEmail("collegeeasy5@gmail.com", "Testing java mail sender", "hi how are you");

//     }

// }
