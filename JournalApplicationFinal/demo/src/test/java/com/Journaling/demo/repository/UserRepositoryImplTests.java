package com.Journaling.demo.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Journaling.controller.demo.Repository.UserRepositoryImpl;
import com.Journaling.controller.demo.entity.User;
import com.mongodb.assertions.Assertions;

@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    public void testSaveNewUser(){
        Assertions.assertNotNull(userRepository.getUsersForSA());
    }

}
