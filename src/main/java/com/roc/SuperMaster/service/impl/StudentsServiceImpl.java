package com.roc.SuperMaster.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roc.SuperMaster.entity.serviceDomain.Students;
import com.roc.SuperMaster.mapper.StudentsMapper;
import com.roc.SuperMaster.service.ParseIdCardService;
import com.roc.SuperMaster.service.StudentsService;
import com.roc.SuperMaster.utility.springUtil.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: WP
 * @Date: 2021/8/22 14:15
 * @Version 1.0
 * @ClassName StudentsServiceImpl.java
 * @Description StudentsServiceImpl
 * @UpdateUser WP
 */
@Slf4j
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {

    @Resource
    private StudentsMapper studentsMapper;

    @Autowired
    private ParseIdCardService parseIdCardService;

    @Override
    public int deleteByPrimaryKey(String studentId) {
        return studentsMapper.deleteByPrimaryKey(studentId);
    }

    @Override
    public int insert(Students record) {
        return studentsMapper.insert(record);
    }

    @Override
    public int insertSelective(Students record) {
        return studentsMapper.insertSelective(record);
    }

    @Override
    public Students selectByPrimaryKey(String studentId) {
        return studentsMapper.selectByPrimaryKey(studentId);
    }

    @Override
    public int updateByPrimaryKeySelective(Students record) {
        return studentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Students record) {
        return studentsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Students> getStudentsList() {
        return null;
    }

    @Override
    public Students getStudentInfoByParam(Students student) {
        return null;
    }

    @Override
    public List<Students> getStudentsListByMPPage(
            Students student,
            Integer pageNum,
            Integer pageSize,
            HttpServletRequest req
    ) {
        List<Students> studentsList = new ArrayList<>();
        log.info("开始获取学生列表，筛选条件：{}", JSONUtil.toJsonStr(req.getParameterMap()));
        try {
            /**
             * 实例化QueryWrapper时参数可以接受请求来的实体对象，也可不接受。
             * 此地最好的方式是构建自己的分页插件，用于拦截来自客户端的多种请求参数。
             * QueryWrapper<>(student);
             * QueryWrapper<>();
             */
            //基础框架下实例化QueryWrapper的三种方式。
            QueryWrapper<Students> queryWrapper = new QueryWrapper<>(student);
            //QueryWrapper<Students> queryWrapper = new QueryWrapper<Students>();
            //LambdaQueryWrapper<Students> queryWrapper = new LambdaQueryWrapper<>(student);
            Page<Students> studentsPage = new Page<>(pageNum, pageSize);
            queryWrapper.lambda()
                    //使用了lambda表达式 可以通过方法引用的方式来使用实体字段名的操作，避免直接写数据库表字段名时的错写名字
                    .eq(Students::getDeleteStatus, false)
                    .orderByDesc(Students::getCreateTime);
            Page<Students> page = studentsMapper.selectPage(studentsPage, queryWrapper);
            studentsList = page.getRecords();
            log.info("查询到的数据条数：{}", page.getRecords().size());
        } catch (Exception e) {
            log.error("errorMsg:", e);
        }
        return studentsList;
    }

    @Override
    public List<Students> getStudentsListByPageHelper() {
        return null;
    }

    @Override
    public Boolean insertStudent(Students student) {

        log.info("开始新增新的学生：{}", JSONUtil.toJsonStr(student));
        try {

            //避免主键重复
            if (Optional.ofNullable(studentsMapper.selectByPrimaryKey(student.getStudentId())).isPresent()) {
                log.error("StudentId重复");
                return false;
            }

            student.setStudentName("littleRoc");
            student.setStudentNumber("20155102");
            student.setStudentCardId("371426199912124057");
            //解析
            boolean parseIdCard = parseIdCardService.parseIdCard(student.getStudentCardId());
            if (parseIdCard) {
                student.setStudentRegisteredResidence(parseIdCardService.parsePCA(student.getStudentCardId()));
                student.setStudentSex(parseIdCardService.parseSex(student.getStudentCardId()));
                student.setStudentAge(parseIdCardService.parseAge(student.getStudentCardId()));
                student.setStudentBirthday(parseIdCardService.parseBirth(student.getStudentCardId()));
            } else {
                log.error("解析IDCard失败，请输入正确的IDCard");
                return false;
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
            int insertToResult = studentsMapper.insert(student);
            if (insertToResult == 1) {
                log.info("新增学生成功");
                return true;
            } else {
                log.error("新增学生失败");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("捕获异常信息：{}", e.getMessage());
            return false;
        }
    }

    @Override
    @LogAnnotation("测试日志")
    public String testLogAnnotation(String name) {
        return "Hello " + name;
    }
}
