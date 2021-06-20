package com.roc.SuperMaster.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author  Roc
 * @date  2021/6/9 17:31
 * @version 1.0
 */

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