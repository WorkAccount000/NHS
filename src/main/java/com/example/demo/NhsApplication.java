package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mybatis.mapper") // MyBatisのマッパーインターフェイスのパッケージを指定
public class NhsApplication {
    public static void main(String[] args) {
        SpringApplication.run(NhsApplication.class, args);
    }
}
