package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InputController {
	@GetMapping("/input")
	public String common(Model model) {
		return "input/input.html";
	}
}
