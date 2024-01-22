package com.Demo.Spring_MVC_Security.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
//		UserDetails john = User.builder()
//				.username("john")
//				.password("{noop}check")
//				.roles("RECRUIT")
//				.build();
//		
//		UserDetails james = User.builder()
//				.username("james")
//				.password("{noop}check")
//				.roles("RECRUIT", "SOLDIER")
//				.build();
//		
//		UserDetails jack = User.builder()
//				.username("jack")
//				.password("{noop}check")
//				.roles("RECRUIT", "SOLDIER", "LIEUTENANT")
//				.build();
//				
		return new JdbcUserDetailsManager(dataSource);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer ->
				configurer
				.requestMatchers(HttpMethod.GET, "/candidates").hasRole("SOLDIER")
				.requestMatchers(HttpMethod.GET, "/candidates/**").hasRole("SOLDIER")
				.requestMatchers(HttpMethod.POST, "/candidates").hasRole("LIEUTENANT")
				.requestMatchers(HttpMethod.PUT, "/candidates").hasRole("LIEUTENANT")
				.requestMatchers(HttpMethod.DELETE, "/candidates").hasRole("GENERAL")
				.requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/")).permitAll()
				);
		
//		http.formLogin(configurer -> 
//				configurer.loginPage("/login"));
		
		http.httpBasic(Customizer.withDefaults());
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
