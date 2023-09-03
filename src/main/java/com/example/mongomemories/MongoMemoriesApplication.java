package com.example.mongomemories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class MongoMemoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoMemoriesApplication.class, args);
		System.out.println("server started on http://localhost:8080/");
	}

}
