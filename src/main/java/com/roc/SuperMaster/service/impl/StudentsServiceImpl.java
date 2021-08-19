package com.roc.SuperMaster.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roc.SuperMaster.entity.domain.Students;
import com.roc.SuperMaster.mapper.StudentsMapper;
import com.roc.SuperMaster.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/6/9 17:31
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentsMapper.deleteByPrimaryKey(id);
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
    public Students selectByPrimaryKey(Integer id) {
        return studentsMapper.selectByPrimaryKey(id);
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
    public List<Students> selectStudentsList() {
        return studentsMapper.selectStudentList();
    }

}
