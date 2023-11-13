package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private final UserService userService;
	private final CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	public CustomAuthenticationProvider(UserService userService, CustomUserDetailsService customUserDetailsService) {
		this.userService = userService;
		this.customUserDetailsService = customUserDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		String hashedPassword = userService.getHashString(password);
		
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		if(userDetails != null && userDetails.getPassword().equals(hashedPassword)) {
			return new UsernamePasswordAuthenticationToken(username, hashedPassword, userDetails.getAuthorities());
		} else {
			throw new BadCredentialsException("Invalid username or password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
