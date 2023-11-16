package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.IntroductionsRequest;

@Controller

public class DetailController { 

@GetMapping("/detail")
	public ModelAndView introDetail(@ModelAttribute IntroductionsRequest ir, ModelAndView mv) {
		mv.addObject("ir", ir);
		mv.setViewName("common/detail");
		return mv;
	}
}