package com.roc.SuperMaster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roc.SuperMaster.entity.serviceDomain.Students;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: WP
 * @Date: 2021/8/22 14:15
 * @Version 1.0
 * @ClassName StudentsService.java
 * @Description 基本的学生服务
 * @UpdateUser WP
 */
public abstract interface StudentsService extends IService<Students> {

    int deleteByPrimaryKey(String studentId);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    /**
     * 获取学生列表:无分页
     *
     * @return
     */
    List<Students> getStudentsList();

    /**
     * 根据条件获取学生信息
     *
     * @param student
     * @return
     */
    Students getStudentInfoByParam(Students student);

    /**
     * 获取学生列表:分页：MyBatis-plus~~page
     *
     * @return
     */
    List<Students> getStudentsListByMPPage(
            Students student,
            Integer pageNum,
            Integer pageSize,
            HttpServletRequest req
    );

    /**
     * 获取学生列表:分页：PageHelper
     *
     * @return
     */
    List<Students> getStudentsListByPageHelper();

    /**
     * 插入学生
     *
     * @param student
     * @return
     */
    Boolean insertStudent(Students student);

}
