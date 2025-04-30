package com.Journaling.controller.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Journaling.controller.demo.Repository.UserRepository;
import com.Journaling.controller.demo.api.response.WeatherResponse;
import com.Journaling.controller.demo.entity.User;
import com.Journaling.controller.demo.service.UserService;
import com.Journaling.controller.demo.service.WeatherService;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userName=authentication.getName();
       User userInDb=userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @DeleteMapping
    public ResponseEntity<?> deleteUserById(@RequestBody User user){
    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    userRepository.deleteByUserName(authentication.getName());
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    
    @GetMapping
    public ResponseEntity<?>greeting(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

   //  String username = (authentication != null) ? authentication.getName() : "Guest";

    WeatherResponse weatherResponse=weatherService.getWeather("Mumbai");



      String greeting="";
    if(weatherResponse!=null){
      greeting=" ,Weather feels like "+weatherResponse.getCurrent().getFeelslike();
    }
       return new ResponseEntity<>("HI "+ authentication.getName()+greeting,HttpStatus.OK);
    }
}
