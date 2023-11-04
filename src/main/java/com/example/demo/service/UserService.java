package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {
	private UserMapper userMapper;
	
	public User search(UserSearchRequest userSearchRequest) {
		return userMapper.search(userSearchRequest);
	}
}
