package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.LoginForm;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@ModelAttribute("form")
	public LoginForm getForm() {
		return new LoginForm();
	}
	
	@GetMapping("/")
	public String getLogin(Model model) {
		return "login/login";
	}
}