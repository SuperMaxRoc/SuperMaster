package com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roc.SuperMaster.mapper.OrderNumberMapper;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Service.OrderNumberService;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.entity.OrderNumber;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Roc
 * @Date 2021/8/16 16:14
 * @Version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description TestOrderServiceImpl
 * @UpdateUser Roc
 */
@Service
public class OrderNumberNumberServiceImpl extends ServiceImpl<OrderNumberMapper, OrderNumber> implements OrderNumberService {

    @Resource
    private OrderNumberMapper orderNumberMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return orderNumberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderNumber record) {
        return orderNumberMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderNumber record) {
        return orderNumberMapper.insertSelective(record);
    }

    @Override
    public OrderNumber selectByPrimaryKey(String id) {
        return orderNumberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderNumber record) {
        return orderNumberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderNumber record) {
        return orderNumberMapper.updateByPrimaryKey(record);
    }

}
