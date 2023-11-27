package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.example.demo.form.InputRequest;

@Mapper
@Component  
public interface InputMapper {
    @Insert("INSERT INTO introductions (name, kana, gender, hobby, word) VALUES (#{name}, #{kana}, #{gender}, #{hobby, typeHandler=com.example.demo.handler.ListTypeHandler}, #{word})")
    void insertInput(InputRequest inputRequest);
}
