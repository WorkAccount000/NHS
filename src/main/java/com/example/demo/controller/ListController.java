package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.mybatis.dmain.Introductions;
import com.example.demo.service.IntroductionsService;

@Controller
public class ListController {
	
	@Autowired
	IntroductionsService introductionsService;
	
	//一覧画面を表示
	
	@GetMapping("/list")
	public String introList(Model model) {
		List<Introductions> intro = introductionsService.introList();
        model.addAttribute("introList", intro); 
		return "common/list.html";
	}
}
