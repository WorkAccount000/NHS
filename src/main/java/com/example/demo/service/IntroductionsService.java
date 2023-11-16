package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.dmain.Introductions;
import com.example.demo.mybatis.mapper.IntroductionsMapper;

@Service
public class IntroductionsService {
	
	@Autowired
	private IntroductionsMapper introductionsMapper;
	
	public List<Introductions> introList() {
		return introductionsMapper.introList();
	}
}
