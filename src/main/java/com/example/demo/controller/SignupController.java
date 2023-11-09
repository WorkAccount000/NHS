package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.SignupForm;
import com.example.demo.service.UserService;

@Controller
public class SignupController {
	private final UserService userService;
	
	@Autowired
	public SignupController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {

		System.out.println(form);
		model.addAttribute("form", form);
		return "signup/signup";
	}
	
	@PostMapping("/signup")
	public String register( Model model,
			//@Validated(GroupOrder.class) @ModelAttribute SignupForm form,
			@Validated @ModelAttribute SignupForm form,
			BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Validated error.");
			System.out.println(form);
			return getSignup(model, form);
		}
//		User user = new User();
//		boolean registrable = userService.checkRegistrable(form.getUserId());
//		String result = "";
//		if(registrable) {
//			user.importForm(form);
//			// post で受け取ったUserクラスの password をハッシュ化
//			user.setPassword(userService.getHashString(user.getPassword()));
//			user.setCreatedDate(LocalDate.now());
//			userService.register(user);
//			result = "top/top";
//		} else {
//			model.addAttribute(form);
//			result = "signup/signup";
//		}
//		return result;
		return "top/top";
	}
}
