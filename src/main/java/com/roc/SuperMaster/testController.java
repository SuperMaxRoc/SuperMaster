package com.roc.SuperMaster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @GetMapping("/hello")
    private String hello(){
        return "hello world and SpringBoot";
    }
}
