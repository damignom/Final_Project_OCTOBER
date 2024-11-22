package com.example.Final_Project_OCTOBER_GitHub;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class FinalProjectOctoberApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectOctoberApplication.class, args);
	}
	/*@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}*/
}
