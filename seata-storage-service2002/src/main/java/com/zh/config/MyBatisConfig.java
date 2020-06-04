package com.zh.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.zh.dao"})
public class MyBatisConfig {
}
