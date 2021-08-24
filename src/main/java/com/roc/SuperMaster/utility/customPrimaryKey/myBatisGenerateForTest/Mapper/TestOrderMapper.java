package com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.entity.TestOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author  Roc
 * @Date  2021/8/16 16:14
 * @Version 1.0.0
 * @ClassName TestOrderMapper.java
 * @Description ToDo
 * @UpdateUser Roc
 */
@Mapper
public interface TestOrderMapper extends BaseMapper<TestOrder> {
    int deleteByPrimaryKey(String id);

    int insert(TestOrder record);

    int insertSelective(TestOrder record);

    TestOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestOrder record);

    int updateByPrimaryKey(TestOrder record);
}