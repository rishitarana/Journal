// package com.Journaling.demo.service;

// import com.Journaling.controller.demo.Repository.UserRepository;
// import com.Journaling.controller.demo.entity.User;
// import com.Journaling.controller.demo.service.UserDetailsServiceImpl;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentMatchers;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.boot.test.context.SpringBootTest;

// import org.springframework.security.core.userdetails.UserDetails;

// import java.util.ArrayList;

// import static org.mockito.Mockito.*;


// @SpringBootTest
// public class UserDetailsServiceImplTestsNew {


//     @InjectMocks
//     private UserDetailsServiceImpl userDetailsService;

//     @Mock
//     private UserRepository userRepository;

//     @BeforeEach
//     void setUp(){
//         MockitoAnnotations.initMocks(this);
//     }
//     @Test
//     void loadUserByUsernameTest(){
//         when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("rishita").password("rishita").roles(new ArrayList<>()).build());
//         UserDetails user=userDetailsService.loadUserByUsername("rishita");
//         Assertions.assertNotNull(user);
//     }
// }
