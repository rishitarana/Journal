package com.Journaling.controller.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.Journaling.controller.demo.entity.User;

public class UserRepositoryImpl {




    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUsersForSA(){
        Query query = new Query();

        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));

        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));

        // query.addCriteria(Criteria.where("userName").is("sham"));
        // query.addCriteria(Criteria.where("field").gte(20));
        // List<User> users=mongoTemplate.find(query,User.class);
        // return users
        
        return mongoTemplate.find(query,User.class);
    }

}
