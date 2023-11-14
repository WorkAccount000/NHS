package com.example.demo.form;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class InputRequest {
	
	private String name;
	private String subName;
	private String gender;
	private List<String> hobby;
	private String comment;
	
}
