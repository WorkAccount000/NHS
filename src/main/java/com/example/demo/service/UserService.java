package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserService {
	private UserMapper userMapper;
	
	public User search(UserSearchRequest userSearchRequest) {
		return userMapper.search(userSearchRequest);
	}
}
