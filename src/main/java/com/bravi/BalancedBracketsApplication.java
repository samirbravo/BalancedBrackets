package com.bravi;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bravi.service.BalancedBracketsService;

@SpringBootApplication
public class BalancedBracketsApplication implements CommandLineRunner{

	@Autowired
	BalancedBracketsService balancedBracketsService;
	

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(BalancedBracketsApplication.class);
		   app.setBannerMode(Banner.Mode.OFF);
		   app.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("Brackets Sequence");
		System.out.println("=======================================");
		System.out.println();
		System.out.println("Please, enter the brackets sequence to validate:");
			
		String sequence = scanner.next();			
		Boolean isValidSequence = balancedBracketsService.isValidSequence(sequence);
		String valid = (isValidSequence == true) ? "is valid" : "is not valid";
		
		System.out.println();
		System.out.println("The sequence " + sequence + " " + valid);
		System.out.println();
		System.out.println("=======================================");
		System.out.println();
	}
}
