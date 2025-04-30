package com.Journaling.demo.service;


import com.Journaling.controller.demo.JournalingApplication;
import com.Journaling.controller.demo.Repository.UserRepository;
import com.Journaling.controller.demo.entity.User;
import com.Journaling.controller.demo.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


//(classes = JournalingApplication.class)//start application context
// @SpringBootTest(classes = com.Journaling.controller.demo.JournalingApplication.class)
@SpringBootTest(classes = JournalingApplication.class) // or your actual app class

public class UserServiceTests{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @ParameterizedTest
    // @ArgumentsSource(UserArgumentsProviderNew.class)
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a,int b, int expected){
        assertEquals(expected,a+b);

    }

}















//package com.Journaling.demo.service;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import com.Journaling.controller.demo.JournalingApplication;
//import com.Journaling.controller.demo.Repository.UserRepository;
//import com.Journaling.controller.demo.entity.User;
//import com.Journaling.controller.demo.service.JournalEntryService;
//import com.Journaling.controller.demo.service.UserService;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest //(classes = JournalingApplication.class)//start application context
//
//public class UserServiceTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserService userService;
//
//
//
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testSaveNewUser(User user) {
//        assertTrue(userService.saveNewUser(user));
//    }
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,9"
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected, a + b);
//    }
//}
