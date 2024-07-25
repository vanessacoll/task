package com.example.tasks.config;

import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan("com.example.tasks.mappers")
public class MyBatisConfig {

}