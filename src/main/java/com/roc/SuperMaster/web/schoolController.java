package com.roc.SuperMaster.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.roc.SuperMaster.domain.Students;
import com.roc.SuperMaster.mapper.StudentsMapper;
import com.roc.SuperMaster.service.StudentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@Api(tags = "第一个测试接口")
@RestController
@Slf4j
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
//            log.info("每一位学生的ID"+students.getId());
            System.out.println(students);
        }
    }

    @ApiOperation(value = "查询全部的学生json")
    @GetMapping("/getStudentsJson")
    public List<Students> getStudentsJson(){
        List<Students> studentsList = studentsMapper.selectStudentList();
        for (Students students : studentsList) {
//            log.info("每一位学生的ID"+students.getId());
            System.out.println(students);
        }
        return studentsList;
    }

    @ApiOperation(value = "按照年龄排序学生")
    @PostMapping("/getStudentsListByAge")
    public List<Students> getStudentsListByAge(){

        QueryWrapper<Students> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");
        List<Students> studentsList = studentsMapper.selectList(queryWrapper);

        for (Students students : studentsList) {
            System.out.println(students);
        }
        return studentsList;
    }

}



