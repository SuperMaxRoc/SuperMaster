package com.roc.SuperMaster.web;

import com.roc.SuperMaster.domain.Students;
import com.roc.SuperMaster.mapper.StudentsMapper;
import com.roc.SuperMaster.service.StudentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "第一个测试接口")
@RestController
@RequestMapping("/test")
public class schoolController {

    @Autowired
    public StudentsService studentsService;

    @Autowired(required = false)
    public StudentsMapper studentsMapper;

    @ApiOperation(value = "根据输入的内容，做出响应")
    @PostMapping("/hello")
    private String hello(@RequestParam(name = "输入的内容" , required = true) String name){
        String str = "wang";
        if(name.equals(str)){
            return "hello world and SpringBoot";
        }else{
            return "you lost";
        }
    }

    @ApiOperation(value = "查询全部的学生")
    @PostMapping("/getStudents")
    private void getStudents(){
        List<Students> studentsList = studentsMapper.selectStudentList();
        for (Students students : studentsList) {
            System.out.println(students);
        }
    }
}
