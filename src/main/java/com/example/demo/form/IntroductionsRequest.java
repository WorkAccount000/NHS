package com.example.demo.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class IntroductionsRequest {
	private String id;
	private String name;
	private String kana;
	private String gender;
	private String hobby;
	private String word;
}
