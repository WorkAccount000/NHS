package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		model.addAttribute("user", new User());
		return "signup/signup";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user, Model model) {
		boolean registrable = userService.checkRegistrable(user.getUserId());
		String result = "";
		if(registrable) {
			// post で受け取ったUserクラスの password をハッシュ化
			user.setPassword(userService.getHashString(user.getPassword()));
			userService.register(user);
			result = "top/top";
		} else {
			model.addAttribute(user);
			result = "signup/signup";
		}
		return result;
	}
}
