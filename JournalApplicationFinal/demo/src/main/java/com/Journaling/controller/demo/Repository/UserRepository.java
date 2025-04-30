package com.Journaling.controller.demo.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Journaling.controller.demo.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {


    User findByUserName(String userName);

    void deleteByUserName(String userName);
    
    
}
