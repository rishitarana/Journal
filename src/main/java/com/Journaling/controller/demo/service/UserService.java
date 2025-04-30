package com.Journaling.controller.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Journaling.controller.demo.Repository.UserRepository;
import com.Journaling.controller.demo.entity.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

   

    public boolean saveNewUser(User user) {
//         try{
// //            user.setPassword(passwordEncoder.encode(user.getPassword()));
//             user.setPassword(passwordEncoder.encode(user.getPassword()));
//             user.setRoles(Arrays.asList("USER"));
//             userRepository.save(user);
//             return true;
//         }
//         catch(Exception e){
//             return false;
//         }

try {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRoles(Arrays.asList("USER"));
    userRepository.save(user);
    return true;
} catch (Exception e) {
    log.error("hahahhahhahahahah");
    log.warn("hahahhahhahahahah");
    log.info("hahahhahhahahahah");
    log.debug("hahahhahhahahahah");
    log.trace("hahahhahhahahahah");
    return false;
}
        
    }


    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userRepository.save(user);
    }


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public void updateById(ObjectId id, User user) {
        userRepository.save(user);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
