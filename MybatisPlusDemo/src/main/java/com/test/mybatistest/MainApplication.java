package com.test.mybatistest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lishuai47
 * @date 2020/4/24 19:43
 * @description
 */
@SpringBootApplication
@MapperScan("com.test.mybatistest.mapper")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
