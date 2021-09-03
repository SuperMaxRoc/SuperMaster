package com.roc.SuperMaster.web.sys;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.roc.SuperMaster.entity.domain.Students;
import com.roc.SuperMaster.service.ParseIdCardService;
import com.roc.SuperMaster.service.StudentsService;
import com.roc.SuperMaster.utility.webResult.WebApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    /**
     * @Author: WP
     * @Date: 2021/8/22 20:01
     * @Version 1.0
     * @Description: 获取学生列表
     * @UpdateUser WP
     * @param student
     * @param pageNum
     * @param pageSize
     * @param req
     * @return com.roc.SuperMaster.utility.webResult.WebApiResult<java.util.List<com.roc.SuperMaster.entity.domain.Students>>
     */
    @ApiOperation(value = "获取学生列表")
    @GetMapping("/getStudentList")
    public WebApiResult<List<Students>> getStudentList(
            Students student,
            @RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
            @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize,
            @RequestParam(name = "deleteStatus",defaultValue = "false") String deleteStatus,
            HttpServletRequest req
    ){
        log.info("开始获取学生列表，筛选条件：{}", JSONUtil.toJsonStr(req.getParameterMap()));
        try{
            QueryWrapper<Students> queryWrapper = new QueryWrapper<>(student);

            Page<Students> studentsPage = new Page<Students>(pageNum,pageSize);
//            queryWrapper.ne("delete_status",true)
//                    .orderByDesc("create_time");
            queryWrapper.lambda()
//                    .ne(Students::getDeleteStatus,deleteStatus)
                    .orderByDesc(Students::getCreateTime);
            Page<Students> page = studentsService.page(studentsPage, queryWrapper);
            List<Students> studentsList = page.getRecords();

            log.info("查询到的数据条数：{}",page.getRecords().size());
            return WebApiResult.ok(studentsList);
        }catch (Exception e){
            e.printStackTrace();
            log.error("捕获异常信息：{}",e.getMessage());
            return WebApiResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "新增新的学生")
    @PostMapping("/addStudent")
    public WebApiResult<?> addStudent(
            @RequestBody Students student
    ){
        log.info("开始新增新的学生：{}",JSONUtil.toJsonStr(student));
        try{

            student.setStudentId("RB0001");
            Students studentInfo = studentsService.selectByPrimaryKey(student.getStudentId());
            if(studentInfo != null){
                log.error("StudentId重复");
                return WebApiResult.error("StudentId重复");
            }
            student.setStudentName("littleRoc");
            student.setStudentNumber("20155102");
            student.setStudentCardId("371426199912124057");
            //解析
            boolean parseIdCard = parseIdCardService.parseIdCard(student.getStudentCardId());
            if (parseIdCard){
                student.setStudentRegisteredResidence(parseIdCardService.parsePCA(student.getStudentCardId()));
                student.setStudentSex(parseIdCardService.parseSex(student.getStudentCardId()));
                student.setStudentAge(parseIdCardService.parseAge(student.getStudentCardId()));
                student.setStudentBirthday(parseIdCardService.parseBirth(student.getStudentCardId()));
            }else {
                log.error("解析IDCard失败，请输入正确的IDCard");
                return WebApiResult.error("请输入正确的IDCard");
            }
            student.setStudentGrade("");
            student.setStudentGradeName("");
            student.setStudentClass("");
            student.setStudentClassName("");
            student.setStudentEmail("");
            student.setStudentStatus("");
            student.setStudentAddress("");
            student.setStudentPhone("15621071234");
            student.setStudentGuardianId("");
            student.setStudentGuardianName("");
            student.setStudentGuardianPhone("");
            student.setStudentGuardianRelationship("");
            student.setStudentAdmissionTime(new Date());
            student.setStudentLeaveTime(new Date());
            student.setRemark("");

            //新增、更新、删除等信息
            student.setCreateBy("Roc");
            student.setCreateTime(new Date());
            student.setUpdateBy("Roc");
            student.setUpdateTime(new Date());
            student.setDeleteBy(null);
            student.setDeleteTime(null);
            student.setDeleteStatus(false);
            //开始插入新的学生
            int insertToResult = studentsService.insert(student);
            if (insertToResult == 1){
                log.info("新增学生成功");
                return WebApiResult.ok("新增学生成功");
            }else {
                log.error("新增学生失败");
                return WebApiResult.error("新增学生失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("捕获异常信息：{}",e.getMessage());
            return WebApiResult.error("新增学生失败");
        }
    }
}
