package com.roc.SuperMaster.web.personalPackage.interestingQuestions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Roc
 * @Date 2021/8/20 22:01
 * @Version 1.0.0
 * @ClassName InterestingQuestions.java
 * @Description 一些有趣的问题的解决方案
 * @UpdateUser Roc
 */
@Slf4j
@RestController
@RequestMapping("/InterestingQuestions")
@Api(tags = "一些有趣的问题的解决方案")
public class InterestingQuestions {


    @ApiOperation(value = "前端输入，验证库中是否已存在")
    @GetMapping("/testRepeat")
    public String testRepeat(
            @RequestParam String targetString
    ){

        return null;
    }

}
