package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.example.demo.form.InputRequest;

@Mapper
@Component  
public interface InputMapper {
    @Insert("INSERT INTO your_table (name, subName, gender, hobby, comment) VALUES (#{name}, #{subName}, #{gender}, #{hobby, typeHandler=com.example.demo.handler.ListTypeHandler}, #{comment})")
    void insertInput(InputRequest inputRequest);
}
