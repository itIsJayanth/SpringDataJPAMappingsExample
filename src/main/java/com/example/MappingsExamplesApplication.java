package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.PerformOperations;

@SpringBootApplication
public class MappingsExamplesApplication {

	@Autowired
	private static PerformOperations operations;

	public MappingsExamplesApplication(PerformOperations operations) {
		super();
		this.operations = operations;
	}

	public static void main(String[] args) {
		SpringApplication.run(MappingsExamplesApplication.class, args);
		System.out.println("Application started");
		// operations.perform();

		// operations.performOneToMany();

		operations.checkTheRelations();
	}

}
