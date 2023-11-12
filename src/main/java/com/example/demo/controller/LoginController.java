package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	private final UserService userService;
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("form")
	public LoginForm getForm() {
		return new LoginForm();
	}
	
	@GetMapping("/")
	public String getLogin(Model model) {
		return "login/login";
	}
	
	@PostMapping("/login_check")
	public String postLogin(Model model,
			@Validated(GroupOrder.class) @ModelAttribute("form") LoginForm form,
			BindingResult result) {
		User user = userService.searchById(form.getUserId());
		if(user != null) {
			String registerPass = user.getPassword();
			String inputPassHash = userService.getHashString(form.getPassword());
			System.out.println(registerPass);
			System.out.println(inputPassHash);
			if(registerPass == inputPassHash) return "redirect:/top/";
		}
		model.addAttribute("form", form);
		return "redirect:/login/";
	}
}