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

import java.util.Date;
import java.util.List;

/**
 * @author Roc
 * @version 1.0
 * @date 2021年7月13日
 */

@Api(tags = "学生测试接口")
@RestController
@Slf4j
@RequestMapping("/test")
public class SchoolController {

    @Autowired
    public StudentsService studentsService;

    @Autowired(required = false)
    public StudentsMapper studentsMapper;

    @ApiOperation(value = "根据输入的内容，做出响应")
    @GetMapping("/hello")
    private String hello(
            @RequestParam(name = "name", required = false) String name
    ) {
        String str = "wang";
        if (name.equals(str)) {
            System.out.println(name);
            return "hello world and SpringBoot";
        } else {
            System.out.println(name);
            return "you lost";
        }
    }

    @ApiOperation(value = "查询全部的学生")
    @PostMapping("/getStudents")
    private void getStudents() {
        List<Students> studentsList = studentsMapper.selectStudentList();
        for (Students students : studentsList) {
            System.out.println(students);
        }
    }

    @ApiOperation(value = "查询全部的学生json")
    @GetMapping("/getStudentsJson")
    public List<Students> getStudentsJson() {
        List<Students> studentsList = studentsMapper.selectStudentList();
        for (Students students : studentsList) {
            System.out.println(students);
        }
        return studentsList;
    }

    @ApiOperation(value = "按照年龄排序学生")
    @PostMapping("/getStudentsListByAge")
    public List<Students> getStudentsListByAge() {

        QueryWrapper<Students> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");
        List<Students> studentsList = studentsMapper.selectList(queryWrapper);

        for (Students students : studentsList) {
            System.out.println(students);
        }
        return studentsList;
    }

    @ApiOperation(value = "添加一个新学生")
    @PostMapping("/insertStudent")
    public void insertStudent(
            @RequestBody Students students
    ){
        log.info("开始添加一个新的学生");
        try {
            students.setId(students.getId());
            students.setName("test");
            students.setAge(students.getAge());
            students.setCreateTime(new Date());
            students.setUpdateTime(new Date());
            students.setStatus(1);
            studentsMapper.insert(students);
        }catch (Exception e){
            e.printStackTrace();
            log.error("异常信息：{}",e.getMessage());
        }
        log.info("添加学生-结束");
    }


}



