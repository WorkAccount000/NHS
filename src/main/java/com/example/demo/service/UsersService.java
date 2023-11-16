package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.mapper.UsersMapper;

@Service
public class UsersService {
	
	@Autowired
	private UsersMapper usersmapper;
}
