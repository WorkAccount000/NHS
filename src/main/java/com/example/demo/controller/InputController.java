package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InputController {
    @GetMapping("/input")
    public String input() {
        return "input";
    }

    @RequestMapping(value = "/inputCheck", method = RequestMethod.POST)
    public ModelAndView inputResult(
            @RequestParam("name") String name,
            @RequestParam("subName") String subName,
            @RequestParam("gender") String gender,
            @RequestParam(value = "hobby", required = false) List<String> hobby,
            @RequestParam("comment") String comment,
            ModelAndView mav) {

        boolean hasError = false;

        // バリデーションチェック
        if (name == null || name.isEmpty()) {
            mav.addObject("nameError", "名前は必須です");
            hasError = true;
        }
        // 他のフィールドに対するバリデーションも同様に行う

        if (hasError) {
            // エラーがある場合、入力フォームに戻る
            mav.setViewName("input");
            // 入力されたデータを再設定
            mav.addObject("name", name);
            mav.addObject("subName", subName);
            mav.addObject("gender", gender);
            mav.addObject("hobby", hobby);
            mav.addObject("comment", comment);
            return mav;
        }

        // エラーがない場合、データをビューに追加して結果画面に遷移
        mav.addObject("name", name);
        mav.addObject("subName", subName);
        mav.addObject("gender", gender);
        mav.addObject("hobby", hobby);
        mav.addObject("comment", comment);
        mav.setViewName("inputCheck");
        return mav;
    }
}
