package com.roc.SuperMaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.roc.SuperMaster.mapper")
public class SuperMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuperMasterApplication.class, args);
    }
}
