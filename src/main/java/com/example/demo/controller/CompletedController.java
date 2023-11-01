package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompletedController {
	@GetMapping("/completed")
	public String completed(Model model) {
		return "completed/completed.html";
	}
}
