package com.cloudwise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cloudwise.dao")
public class Cloudwise20201214WorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cloudwise20201214WorkApplication.class, args);
    }

}
