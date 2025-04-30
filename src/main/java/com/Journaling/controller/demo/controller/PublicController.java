package com.Journaling.controller.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Journaling.controller.demo.entity.User;
import com.Journaling.controller.demo.service.UserDetailsServiceImpl;
import com.Journaling.controller.demo.service.UserService;
import com.Journaling.controller.demo.utils.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/public")
public class PublicController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }


    //createuser
    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userService.saveNewUser(user);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
       try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        UserDetails userDetails=userDetailsService.loadUserByUsername(user.getUserName());
        String jwt=jwtUtil.generateToken(userDetails.getUsername());
        return new ResponseEntity<>(jwt, HttpStatus.OK);

       }
       catch(Exception e){

        log.error("exception occured while createAuthentication", e);
        return new ResponseEntity<>("Incorrect username or password",HttpStatus.BAD_REQUEST);
       }
    }
}