package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String email;
	private String password;
	private Date createdDate;

}