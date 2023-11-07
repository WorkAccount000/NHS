package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.SignupForm;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class SignupController {
	private final UserService userService;
	
	@Autowired
	public SignupController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "signup/signup";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute SignupForm form, Model model) {
		User user = new User();
		boolean registrable = userService.checkRegistrable(form.getUserId());
		String result = "";
		if(registrable) {
			user.importForm(form);
			// post で受け取ったUserクラスの password をハッシュ化
			user.setPassword(userService.getHashString(user.getPassword()));
			user.setCreatedDate(LocalDate.now());
			userService.register(user);
			result = "top/top";
		} else {
			model.addAttribute(form);
			result = "signup/signup";
		}
		return result;
	}
}
