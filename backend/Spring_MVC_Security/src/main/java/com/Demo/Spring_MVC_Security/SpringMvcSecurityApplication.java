package com.Demo.Spring_MVC_Security;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Demo.Spring_MVC_Security.Entity.User;
import com.Demo.Spring_MVC_Security.Repository.UserRepository;

@SpringBootApplication
public class SpringMvcSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcSecurityApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("James", "John", "Jenny")
			.forEach(name -> {User user = new User(name, name.toLowerCase() + "@domain.com");
			userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
