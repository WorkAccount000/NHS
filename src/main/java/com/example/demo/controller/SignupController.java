package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.GroupOrder;
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
	public String getSignup(Model model) {
		model.addAttribute("form", new SignupForm());
		return "signup/signup";
	}
	
	@PostMapping("/signup")
	public String register( Model model,
			@Validated(GroupOrder.class) @ModelAttribute("form") SignupForm form,
			BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Validated error.");
			model.addAttribute("form", form);
			return "signup/signup";
		}
		User user = new User();
		boolean registrable = userService.checkRegistrable(form.getUserId());
		String res = "";
		if(registrable) {
			user.importForm(form);
			// post で受け取ったUserクラスの password をハッシュ化
			user.setPassword(userService.getHashString(user.getPassword()));
			user.setCreatedDate(LocalDate.now());
			userService.register(user);
			res = "redirect:/top/";
		} else {
			model.addAttribute(form);
			res = "signup/signup";
		}
		return res;
	}
}
