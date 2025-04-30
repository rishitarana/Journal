package com.Journaling.demo.service;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.springframework.security.core.userdetails.UserDetails;

import com.Journaling.controller.demo.Repository.UserRepository;
import com.Journaling.controller.demo.entity.User;
import com.Journaling.controller.demo.service.UserDetailsServiceImpl;
import com.mongodb.assertions.Assertions;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

@ActiveProfiles("dev")
public class UserDetailsServiceImplTests {

  @InjectMocks
   private UserDetailsServiceImpl userDetailsService;

   @Mock
   private UserRepository userRepository;


   @BeforeEach
   void setUp(){
       MockitoAnnotations.initMocks(this);
   }

   @Test
   void loadUserByUsernameTest() {
       // Creating a mock User entity
       User mockUser = new User();
       mockUser.setUserName("ram");
       mockUser.setPassword("inrinrick");
       mockUser.setRoles(new ArrayList<>());

       // Mocking repository behavior
       when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(mockUser);

       // Calling the method
       UserDetails user = userDetailsService.loadUserByUsername("ram");

       // Assertion
       Assertions.assertNotNull(user);
   }
}



// package com.Journaling.demo.service;

// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentMatchers;
// import com.Journaling.controller.demo.entity.User;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.Journaling.controller.demo.Repository.UserRepository;
// import com.Journaling.controller.demo.service.UserDetailsServiceImpl;
// import com.mongodb.assertions.Assertions;

// import static org.mockito.Mockito.*;

// import java.util.ArrayList;


// @SpringBootTest
// public class UserDetailsServiceImplTests {

//     @Autowired
//     private UserDetailsServiceImpl userDetailsService;


//     @Mock
//     private UserRepository userRepository;



//     @Test

//     void  loadUserByUsernameTest(){

//         when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//     .thenReturn((com.Journaling.controller.demo.entity.User)
//     User
//     .builder()
//     .username("ram")
//     .password("inrinrick")
//     .roles(new ArrayList<>())
//     .build()
//     );
//      UserDetails user = userDetailsService.loadUserByUsername("ram");
//     Assertions.assertNotNull(user);

//         // when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("inrinrick").build());
//         // UserDetails user = userDetailsService.loadUserByUsername("ram");
//     }
// }


