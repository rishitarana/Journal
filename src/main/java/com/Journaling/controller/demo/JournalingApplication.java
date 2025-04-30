package com.Journaling.controller.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class JournalingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalingApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);



	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


	
}

//platform transaction manager
//mongotransactionmanager