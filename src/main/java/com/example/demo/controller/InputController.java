package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.InputRequest;
import com.example.demo.mybatis.dmain.Introductions;
import com.example.demo.mybatis.mapper.IntroductionsMapper;

import jakarta.validation.Valid;

@Controller
public class InputController {

    @Autowired
    private IntroductionsMapper introductionsMapper;

    @GetMapping("/input")
    public String input(Model model) {
        model.addAttribute("inputRequest", new InputRequest()); 
        return "input";
    }


    @RequestMapping(value = "/inputCheck", method = RequestMethod.POST)
    public ModelAndView inputResult(@Valid @ModelAttribute("inputRequest") InputRequest ir, BindingResult bindingResult, ModelAndView mv) {
        if (bindingResult.hasErrors()) {
            mv.setViewName("input");
            return mv;
        }
        mv.addObject("ir", ir);
        mv.setViewName("inputCheck");
        return mv;
    }

    @PostMapping("/saveInput")
    public ModelAndView saveInput(@ModelAttribute("ir") InputRequest ir, ModelAndView mv) {
        Introductions introductions = convertToEntity(ir);
        introductionsMapper.insert(introductions);

        mv.addObject("ir", ir);
        mv.setViewName("inputCheck");
        return mv;
    }

    private Introductions convertToEntity(InputRequest ir) {
        Introductions introductions = new Introductions();
        introductions.setName(ir.getName());
        introductions.setKana(ir.getKana());
        introductions.setGender(ir.getGender());
        introductions.setHobby(String.join(", ", ir.getHobby()));
        introductions.setWord(ir.getWord());

        return introductions;
    }
}
