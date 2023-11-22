package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final CustomAuthenticationProvider customAuthProvider;
	private final CustomAuthenticationFailureHandler customAuthFailureHandler;
	
	@Autowired
	public SecurityConfig(CustomAuthenticationProvider customAuthProvider, CustomAuthenticationFailureHandler customAuthFailureHandler) {
		this.customAuthProvider = customAuthProvider;
		this.customAuthFailureHandler = customAuthFailureHandler;
	}
//	@Autowired
//	public SecurityConfig(CustomAuthenticationProvider customAuthProvider) {
//		this.customAuthProvider = customAuthProvider;
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.formLogin(
				login -> login
					.loginPage("/login/")
					.usernameParameter("username")
					.passwordParameter("password")
					.loginProcessingUrl("/login/login_check")
					.permitAll()
					.defaultSuccessUrl("/top/", true)
					.failureHandler(customAuthFailureHandler)
//					.failureUrl("/login/?error=true")
					)
			.authorizeHttpRequests(
				test -> test
					.requestMatchers("/signup").permitAll()
					.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
					.anyRequest().authenticated());
		return http.build();
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthProvider);
	}
}