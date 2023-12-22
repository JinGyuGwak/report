package com.example.outlier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OutlierApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutlierApplication.class, args);
		System.out.println("실행");
	}
}
