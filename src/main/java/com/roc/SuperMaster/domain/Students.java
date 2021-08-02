package com.roc.SuperMaster.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/6/9 17:31
 */
@ApiModel(value = "学生实体类")
@Data
public class Students implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;

    private Integer status;

    private static final long serialVersionUID = 1L;
}