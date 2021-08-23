package com.roc.SuperMaster.entity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: WP
 * @Date: 2021/8/23 22:48
 * @Version 1.0
 * @ClassName Pca.java
 * @Description 2018版全国行政区代码表
 * @UpdateUser WP
 */

/**
 * 2018版全国行政区代码表
 */
@ApiModel(value = "com-roc-SuperMaster-entity-domain-Pca")
@Data
public class Pca implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long pcaId;

    /**
     * 行政区code
     */
    @ApiModelProperty(value = "行政区code")
    private String pcaCode;

    /**
     * 行政区name
     */
    @ApiModelProperty(value = "行政区name")
    private String pcaName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 删除人
     */
    @ApiModelProperty(value = "删除人")
    private String deleteBy;

    /**
     * 删除时间
     */
    @ApiModelProperty(value = "删除时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteTime;

    /**
     * 删除状态
     */
    @ApiModelProperty(value = "删除状态")
    private Boolean deleteStatus;

    private static final long serialVersionUID = 1L;
}