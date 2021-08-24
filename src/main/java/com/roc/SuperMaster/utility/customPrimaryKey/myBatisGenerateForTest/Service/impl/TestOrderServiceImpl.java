package com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Mapper.TestOrderMapper;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Service.TestOrderService;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.entity.TestOrder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Author  Roc
 * @Date  2021/8/16 16:14
 * @Version 1.0.0
 * @ClassName TestOrderServiceImpl.java
 * @Description ToDo
 * @UpdateUser Roc
 */
@Service
public class TestOrderServiceImpl extends ServiceImpl<TestOrderMapper, TestOrder> implements TestOrderService {

    @Resource
    private TestOrderMapper testOrderMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return testOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TestOrder record) {
        return testOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(TestOrder record) {
        return testOrderMapper.insertSelective(record);
    }

    @Override
    public TestOrder selectByPrimaryKey(String id) {
        return testOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TestOrder record) {
        return testOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TestOrder record) {
        return testOrderMapper.updateByPrimaryKey(record);
    }

}
