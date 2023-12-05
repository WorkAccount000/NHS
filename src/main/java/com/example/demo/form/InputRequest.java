package com.example.demo.form;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputRequest {
    @NotEmpty(message = "名前は必須項目です。")
    @Size(max = 10, message = "名前は10文字以内で入力してください。")
    private String name;

    @NotEmpty(message = "フリガナは必須項目です。")
    @Size(max = 20, message = "フリガナは20文字以内で入力してください。")
    private String kana;

    @NotEmpty(message = "趣味は必須項目です。1つ以上選んでください。")
    private List<String> hobby;

    private String gender;
    
    private String word; // 他のフィールド
}
