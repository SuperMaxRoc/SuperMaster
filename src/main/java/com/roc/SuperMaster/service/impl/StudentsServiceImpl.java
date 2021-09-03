package com.roc.SuperMaster.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roc.SuperMaster.entity.domain.Students;
import com.roc.SuperMaster.mapper.StudentsMapper;
import com.roc.SuperMaster.service.StudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @Author: WP
 * @Date: 2021/8/22 14:15
 * @Version 1.0
 * @ClassName StudentsServiceImpl.java
 * @Description StudentsServiceImpl
 * @UpdateUser WP
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper,Students> implements StudentsService {

    @Resource
    private StudentsMapper studentsMapper;

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

}
