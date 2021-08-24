package com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.entity.TestOrder;

/**
 * @Author  Roc
 * @Date  2021/8/16 16:14
 * @Version 1.0.0
 * @ClassName TestOrderService.java
 * @Description ToDo
 * @UpdateUser Roc
 */

public interface TestOrderService extends IService<TestOrder> {


    int deleteByPrimaryKey(String id);

    int insert(TestOrder record);

    int insertSelective(TestOrder record);

    TestOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestOrder record);

    int updateByPrimaryKey(TestOrder record);

}
