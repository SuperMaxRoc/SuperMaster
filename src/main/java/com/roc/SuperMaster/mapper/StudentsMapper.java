package com.roc.SuperMaster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roc.SuperMaster.entity.domain.Students;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: WP
 * @Date: 2021/8/22 14:15
 * @Version 1.0
 * @ClassName StudentsMapper.java
 * @Description ToDo
 * @UpdateUser WP
 */
@Mapper
public interface StudentsMapper extends BaseMapper<Students> {
    int deleteByPrimaryKey(String studentId);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);
}