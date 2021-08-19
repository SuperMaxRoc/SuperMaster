package com.roc.SuperMaster.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Integer status;

    private static final long serialVersionUID = 1L;
}