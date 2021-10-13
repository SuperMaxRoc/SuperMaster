package com.roc.SuperMaster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.entity.OrderNumber;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Roc
 * @Date 2021/8/16 16:14
 * @Version 1.0.0
 * @ClassName OrderMapper.java
 * @Description OrderMapper
 * @UpdateUser Roc
 */
@Mapper
public interface OrderNumberMapper extends BaseMapper<OrderNumber> {

    int deleteByPrimaryKey(String id);

    int insert(OrderNumber record);

    int insertSelective(OrderNumber record);

    OrderNumber selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderNumber record);

    int updateByPrimaryKey(OrderNumber record);
}