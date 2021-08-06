package com.roc.SuperMaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.roc.SuperMaster.mapper")
@EnableScheduling
public class SuperMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuperMasterApplication.class, args);
    }
}
