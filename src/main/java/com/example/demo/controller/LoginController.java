package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.GroupOrder;
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
		model.addAttribute("loginForm", new LoginForm());
		return "login/login";
	}
	
	@PostMapping("/login_check")
	public String checkLogin(@Validated(GroupOrder.class) @ModelAttribute("form") LoginForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "login/login";
		}
		return "redirect:/login_check";
	}
}