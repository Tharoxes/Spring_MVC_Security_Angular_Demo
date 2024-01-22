package com.Demo.Spring_MVC_Security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.Demo.Spring_MVC_Security.Repository.CandidateRepository;

@SpringBootApplication
public class SpringMvcSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcSecurityApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner init (CandidateRepository candidateRepository) {
//		return args -> {
//			Stream.of("James", "John", "Jenny")
//			.forEach(name -> {Candidate candidate = new Candidate(name, name.toUpperCase(), name.toLowerCase() + "@domain.com");
//			candidateRepository.save(candidate);
//			});
//			candidateRepository.findAll().forEach(System.out::println);
//		};
//	}
	
	@Bean
	CommandLineRunner init (CandidateRepository candidateRepository, UserDetailsService service) {
		return args -> {
			candidateRepository.findAll().forEach(System.out::println);
			UserDetails user = service.loadUserByUsername("james");
			System.out.println(user.getPassword());
		};
	}

}
