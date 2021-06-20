package com.roc.SuperMaster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roc.SuperMaster.domain.Students;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  Roc
 * @date  2021/6/9 17:31
 * @version 1.0
 */

@Service
public interface StudentsService extends IService<Students> {


    int deleteByPrimaryKey(Integer id);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    List<Students> selectStudentsList();

}
