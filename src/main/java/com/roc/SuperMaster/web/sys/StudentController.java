package com.roc.SuperMaster.web.sys;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import com.roc.SuperMaster.entity.serviceDomain.Students;
import com.roc.SuperMaster.mapper.StudentsMapper;
import com.roc.SuperMaster.service.FormatSQLService;
import com.roc.SuperMaster.service.ParseIdCardService;
import com.roc.SuperMaster.service.StudentsService;
import com.roc.SuperMaster.utility.springUtil.LogAnnotation;
import com.roc.SuperMaster.utility.webResult.ExecuteResult;
import com.roc.SuperMaster.utility.webResult.WebApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WP
 * @Date: 2021/8/22 14:17
 * @Version 1.0
 * @ClassName studentController.java
 * @Description 学生信息处理
 * @UpdateUser WP
 */
@Slf4j
@RequestMapping("/Students")
@RestController
@Api(tags = "学生信息处理")
public class StudentController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private ParseIdCardService parseIdCardService;

    @Autowired
    private FormatSQLService formatSQLService;

    /**
     * @param student
     * @param pageNum
     * @param pageSize
     * @param req
     * @return com.roc.SuperMaster.utility.webResult.WebApiResult<java.util.List < com.roc.SuperMaster.entity.serviceDomain.Students>>
     * @Author: WP
     * @Date: 2021/8/22 20:01
     * @Version 1.0
     * @Description: 获取学生列表
     * @UpdateUser WP
     */
    @ApiOperation(value = "获取学生列表")
    @GetMapping("/getStudentList")
    public WebApiResult<List<Students>> getStudentList(
            Students student,
            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            HttpServletRequest req
    ) {
        WebApiResult<List<Students>> result = new WebApiResult<List<Students>>() {{
            setData(studentsService.getStudentsListByMPPage(student, pageNum, pageSize, req));
        }};
        return result;
    }

    /**
     * @param student
     * @return com.roc.SuperMaster.utility.webResult.WebApiResult<Boolean>
     * @Author: WangPeng
     * @Date: 2022/4/24 16:41
     * @Description: 新增学生
     */
    @ApiOperation(value = "新增新的学生")
    @PostMapping("/addStudent")
    public WebApiResult<Boolean> addStudent(
            @RequestBody Students student
    ) {
        return new WebApiResult<Boolean>() {{
            setData(studentsService.insertStudent(student));
        }};
    }

    @Autowired
    StudentsMapper studentsMapper;

    @GetMapping("batchGetInfo")
    public List<Students> batchGetInfos(
            @RequestParam List<String> ids
    ) {
        List<Students> students = new ArrayList<>();
        for (String id : ids) {
            LambdaQueryWrapper<Students> studentsLambdaQueryWrapper = new LambdaQueryWrapper<>();
            studentsLambdaQueryWrapper.eq(Students::getStudentId, id);
            Students serviceOne = studentsService.getOne(studentsLambdaQueryWrapper);
            students.add(serviceOne);
        }
        return students;
    }

    @GetMapping("/getStudent")
    public Students getOne(
            Students students
    ) {
        return studentsMapper.getOnerous(students);
    }

    @PostMapping("/testMock")
    public Students testMock(
            @RequestBody @Valid Students students
    ) {
        Students mock = JMockData.mock(new TypeReference<Students>() {
        });
        return mock;
    }

    @GetMapping("/testCode")
    @LogAnnotation("ceshi")
    public String testCode(
            @RequestParam String code,
            @RequestBody List<Students> testament
    ) {
        //String connect = null;

        //JSONObject jsonObject = new JSONObject() {{
        //    put("expno", null);
        //    put("orderno", "nihao");
        //}};
        //connect = JSONObject.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue);
        System.out.println(code);
        //System.out.println(1/0);
        return studentsService.testLogAnnotation(code);
    }

    @PostMapping("formatSQL")
    public ExecuteResult<String> formatSQL(
            @RequestBody JSONObject jsonObject
    ) {
        String preparingSQL = jsonObject.getString("preparingSQL");
        String parameters = jsonObject.getString("parameters");
        return formatSQLService.formatSql(preparingSQL, parameters);
    }
}
