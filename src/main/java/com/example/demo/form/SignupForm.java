package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(groups = ValidGroup1.class)
	@Pattern(regexp="^[!-~]+$", message="{0}は半角英数字のみで入力してください。", groups = ValidGroup3.class)
	@Length(min=3, max=10, groups = ValidGroup4.class)
	@Pattern(regexp="^[0-9A-Za-z]+$", message="{0}は特殊記号を使用しないでください。", groups = ValidGroup5.class)
	private String userId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	@Pattern(regexp="^[!-~]+$", message="{0}は半角英数字のみで入力してください。", groups = ValidGroup3.class)
	private String email;
	
	@NotBlank(groups = ValidGroup1.class)
	@Pattern(regexp="^[!-~]+$", message="{0}は半角英数字のみで入力してください。", groups = ValidGroup3.class)
	@Length(min=3, max=10, groups = ValidGroup4.class)
	@Pattern(regexp="^[!-~]+$", message="{0}は大文字小文字数字を入力してください。", groups = ValidGroup5.class)
	@Pattern(regexp="^[0-9A-Za-z]+$", message="{0}は特殊記号を使用しないでください。", groups = ValidGroup6.class)
	private String password;
}
