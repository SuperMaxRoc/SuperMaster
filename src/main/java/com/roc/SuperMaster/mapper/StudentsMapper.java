package com.roc.SuperMaster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roc.SuperMaster.domain.Students;

import java.util.List;

/**
 * @author  Roc
 * @date  2021/6/9 17:31
 * @version 1.0
 */
public interface StudentsMapper extends BaseMapper<Students> {
    int deleteByPrimaryKey(Integer id);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    List<Students> selectStudentList();
}