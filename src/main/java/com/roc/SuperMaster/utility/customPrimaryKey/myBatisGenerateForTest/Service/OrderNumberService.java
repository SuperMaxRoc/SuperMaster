package com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.entity.OrderNumber;

/**
 * @Author  Roc
 * @Date  2021/8/16 16:14
 * @Version 1.0.0
 * @ClassName OrderService.java
 * @Description TestOrderService
 * @UpdateUser Roc
 */

public interface OrderNumberService extends IService<OrderNumber> {


    int deleteByPrimaryKey(String id);

    int insert(OrderNumber record);

    int insertSelective(OrderNumber record);

    OrderNumber selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderNumber record);

    int updateByPrimaryKey(OrderNumber record);

}
