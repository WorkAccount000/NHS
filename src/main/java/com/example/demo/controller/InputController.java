package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.InputRequest;
import com.example.demo.mapper.InputMapper;

@Controller
public class InputController {
	@GetMapping("/input")
	public String input() {
		return "input";
	}

	@Autowired
	private InputMapper inputMapper;

	@RequestMapping(value = "/inputCheck", method = RequestMethod.POST)
	public ModelAndView inputResult(@ModelAttribute InputRequest ir, ModelAndView mv) {
		mv.addObject("ir", ir);
		mv.setViewName("inputCheck");
		return mv;
	}

	@PostMapping("/saveInput")
	public ModelAndView saveInput(@ModelAttribute InputRequest ir, ModelAndView mv) {
		inputMapper.insertInput(ir); // データをデータベースに登録
		mv.addObject("ir", ir);
		mv.setViewName("inputCheck"); // 同じ確認画面に戻る
		return mv;
	}
}
