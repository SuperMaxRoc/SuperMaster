package com.roc.SuperMaster.utility.customPrimaryKey.myBatisGenerate;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author  Roc
 * @Date  2021/8/16 16:14
 * @Version 1.0.0
 * @ClassName TestOrder.java
 * @Description 订单表
 * @UpdateUser Roc
 */

/**
    * 订单表
    */
@Data
public class TestOrder implements Serializable {
    /**
    * 订单编号
    */
    private String id;

    /**
    * 备注
    */
    private String remark;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建日期
    */
    private Date createTime;

    /**
    * 更新人
    */
    private String updateBy;

    /**
    * 更新日期
    */
    private Date updateTime;

    /**
    * 删除时间
    */
    private Date deleteTime;

    /**
    * 删除人
    */
    private String deleteBy;

    /**
    * 删除状态：false 0 数据无效已删除,true 1 数据有效未删除
    */
    private Boolean deleteStatus;

    private static final long serialVersionUID = 1L;
}