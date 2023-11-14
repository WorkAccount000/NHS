package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.InputRequest;


@Controller
public class InputController {
	@RequestMapping("/input")
	public String nyuuryoku(){
		return "/input/input"; 
	}

	@RequestMapping("/inputCheck")
	public ModelAndView inputResult(@ModelAttribute InputRequest ir, ModelAndView mav) {
		mav.addObject("ir", ir);
		mav.setViewName("/input/inputCheck.html"); 
		return mav;
	}
}