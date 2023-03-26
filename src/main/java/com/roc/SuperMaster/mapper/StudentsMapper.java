package com.roc.SuperMaster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roc.SuperMaster.entity.serviceDomain.Students;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: WP
 * @Date: 2021/8/22 14:15
 * @Version 1.0
 * @ClassName StudentsMapper.java
 * @Description StudentsMapper
 * @UpdateUser WP
 */
@Mapper
public interface StudentsMapper extends BaseMapper<Students> {

    int deleteByPrimaryKey(String studentId);

    @Override
    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    Students getOnerous(Students students);
}