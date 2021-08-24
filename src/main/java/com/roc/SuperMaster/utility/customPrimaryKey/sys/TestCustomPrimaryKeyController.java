package com.roc.SuperMaster.utility.customPrimaryKey.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.entity.TestOrder;
import com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerateForTest.Service.TestOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author Roc
 * @Date 2021/8/16 15:36
 * @Version 1.0.0
 * @ClassName TestCustomPrimaryKey.java
 * @Description 自定义数据库主键的实现方案
 * @UpdateUser Roc
 */
@Slf4j
@Api(value = "自定义数据库主键的实现方案")
@RestController
@RequestMapping
public class TestCustomPrimaryKeyController {

    @Autowired
    TestOrderService testOrderService;

    /**
     *数据库主键：
     * 1）保证实体的完整性;
     * 2）加快数据库的操作速度;
     * 3）在表中添加新记录时，DBMS会自动检查新记录的主键值，不允许该值与其他记录的主键值重复;
     * 4) DBMS自动按主键值的顺序显示表中的记录。如果没有定义主键，则按输入记录的顺序显示表中的记录。
     * */

    /**
     * 主键的类型：
     * 1.int类型的整数，从1开始，随着插入的数据不断增加，且非空
     * 2.varchar类型的随机数，通过多种生成方法，生成全局唯一的ID，可由UUID方法或者Random生成，详情请假utility.random包下的random类
     * 3.varchar类型的一定规则的编码
     *      (1.)一定规则的编号：“FB0001”、“FB0002”
     *      (2.)带时间的订单编号：20210816153226765001，携带当前时间的订单Info
     */

    /**
     * 本类主要讨论上文的3.1和3.2的实现方式
     * */

    /**
     * 生成一定规则的编号：一定规则的编号：“FB0001”、“FB0002”
     *
     * 思路：1.拼接字符串，每次生成，去库中查询一遍当前表的编号，切割固定的字符串，然后自增+1，（通常采用逻辑删除，不考虑被删除的数据，列表显示会出现编号不连续）
     */

    @ApiOperation(value = "测试拼接字符串用于更新一定规则的OrderID")
    @PutMapping("/testCustomNumByJava")
    public void testCustomNum(
            @RequestBody TestOrder testOrder
    ){
        //1.库中创建测试表
        /*create table if not exists test_Order(
                id                               varchar(36)          not null primary key  comment '订单编号',
                remark                           varchar(36)          not null              comment '备注',
        #---------------------------------------------------------------------------------------------------------------------------
                create_by                        varchar(250)         not null              comment '创建人',
                create_time                      datetime             not null              comment '创建日期',
                update_by                        varchar(250)             null              comment '更新人',
                update_time                      datetime                 null              comment '更新日期',
                delete_time                      datetime                                   comment '删除时间',
                delete_by                        varchar(250)                               comment '删除人',
                delete_status                    boolean default true not null comment '删除状态：false 0 数据无效已删除,true 1 数据有效未删除'
        )Engine = InnoDB character set utf8 comment '订单表';

        select * from test_Order;*/

        //2.Mybatis-generate

        //3.整体思路：库中没有数据，固定插入第一条数据的固定ID/库中有数据，获取最新创建的数据的ID，截取然后+1形成新的ID
        //查询库中的数据
        List<TestOrder> list = testOrderService.list();

        //格式化ID的数字部分
        DecimalFormat decimalFormat = new DecimalFormat("000000");

        if (list.size() == 0){
            //如果库中没有数据，编号则从“FB000001”开始
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            String lastTargetId = decimalFormat.format(i);
            //按照规则拼接目标ID
            String numString = stringBuilder.append("FB").append(lastTargetId).toString();
            testOrder.setId(numString);
        } else {
            //如果库中有数据，则获取最新的订单，进而再做处理

            //查询最新的一条数据
            QueryWrapper<TestOrder> queryWrapper = new QueryWrapper<>();
            //不考虑被逻辑删除的部分
            //放弃时间排序：创建时间相同，容易出错，Date的时间粒度仅在秒级
            //queryWrapper.orderByDesc("create_time");
            queryWrapper.orderByDesc("id");
            List<TestOrder> orderList = testOrderService.list(queryWrapper);

            //获取最新数据的ID，且格式化
            TestOrder targetOrder = orderList.get(0);
            String targetOrderId = targetOrder.getId();
            String substring = targetOrderId.substring(2,targetOrderId.length());
            int parseInt = Integer.parseInt(substring);

            //拼接最新的数据的ID
            int targetIdByInt = parseInt + 1;
            //格式化目标ID的数字部分，然后拼接
            String lastTargetId = decimalFormat.format(targetIdByInt);
            StringBuilder stringBuilder = new StringBuilder();
            String targetOrderByString = stringBuilder.append("FB").append(lastTargetId).toString();

            testOrder.setId(targetOrderByString);
        }

        //新增其他数据
        testOrder.setRemark("Hello,World!");
        testOrder.setCreateBy("Roc");
        testOrder.setCreateTime(new Date());
        testOrder.setUpdateBy("Roc");
        testOrder.setUpdateTime(new Date());
        testOrder.setDeleteBy(null);
        testOrder.setDeleteTime(null);
        testOrder.setDeleteStatus(true);

        //4.开始插入数据
        testOrderService.insert(testOrder);
    }

    /**
     * @Author: WP
     * @Date: 2021/8/16 16:02
     * @Version 1.0
     * @Description: 测试GenerateOrderNumber
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testGenerateOrderNumber(){
        for (int i = 0; i < 5; i++) {
            System.out.println(GenerateOrderNumber.generateOrder());
        }
    }

    @Test
    public void testVoid(){
        DecimalFormat decimalFormat=new DecimalFormat("000000");
        String code="XQ20190417000100";
        String codeNew = code.substring(10, code.length());
        int i=Integer.parseInt(codeNew)+1;
        String k=decimalFormat.format(i);
        System.out.println(k);
    }




}
