package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private final UserService userService;
	
	@Autowired
	public CustomAuthenticationProvider(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		String hashedPassword = userService.getHashString(password);
		return new UsernamePasswordAuthenticationToken(username, hashedPassword);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO 自動生成されたメソッド・スタブ
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
