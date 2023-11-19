package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.form.InputRequest;

@Mapper
public interface InputMapper {
    @Insert("INSERT INTO your_table (name, subName, gender, hobby, comment) VALUES (#{name}, #{subName}, #{gender}, #{hobby}, #{comment})")
    void insertInput(InputRequest inputRequest);
}
