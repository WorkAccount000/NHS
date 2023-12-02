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
import com.example.demo.mybatis.dmain.Introductions;
import com.example.demo.mybatis.mapper.IntroductionsMapper;

@Controller
public class InputController {

    @Autowired
    private IntroductionsMapper introductionsMapper;

    @GetMapping("/input")
    public String input() {
        return "input";
    }

    @RequestMapping(value = "/inputCheck", method = RequestMethod.POST)
    public ModelAndView inputResult(@ModelAttribute InputRequest ir, ModelAndView mv) {
        mv.addObject("ir", ir);
        mv.setViewName("inputCheck");
        return mv;
    }

    @PostMapping("/saveInput")
    public ModelAndView saveInput(@ModelAttribute InputRequest ir, ModelAndView mv) {
        Introductions introductions = convertToEntity(ir);
        introductionsMapper.insert(introductions);

        mv.addObject("ir", ir);
        mv.setViewName("inputCheck"); // 同じ確認画面に戻る
        return mv;
    }

    private Introductions convertToEntity(InputRequest ir) {
        // InputRequestからIntroductionsエンティティに変換するロジックを実装
        Introductions introductions = new Introductions();
        introductions.setName(ir.getName());
        introductions.setKana(ir.getKana());
        introductions.setGender(ir.getGender());
        introductions.setWord(ir.getWord());

        return introductions;
    }
}
