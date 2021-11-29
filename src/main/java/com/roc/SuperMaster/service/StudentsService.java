package com.roc.SuperMaster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roc.SuperMaster.entity.domain.Students;

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

}
