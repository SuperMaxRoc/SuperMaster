package com.roc.SuperMaster.entity.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: WP
 * @Date: 2021/8/22 14:15
 * @Version 1.0
 * @ClassName Students.java
 * @Description 学生信息表
 * @UpdateUser WP
 */
/**
    * 学生信息表
    */
@ApiModel(value="com-roc-SuperMaster-entity-domain-Students")
@Data
public class Students implements Serializable {

    /**
     * 学生ID
     * Mybatis-plus主键自增
     * */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="学生ID")
    @Excel(name = "学生ID",width = 15.0)
    private String studentId;

    /**
    * 学生姓名
    */
    @ApiModelProperty(value="学生姓名")
    private String studentName;

    /**
    * 学生学号
    */
    @ApiModelProperty(value="学生学号")
    private String studentNumber;

    /**
    * 学生身份证
    */
    @ApiModelProperty(value="学生身份证")
    private String studentCardId;

    /**
    * 学生性别
    */
    @ApiModelProperty(value="学生性别")
    private String studentSex;

    /**
    * 学生年龄
    */
    @ApiModelProperty(value="学生年龄")
    private Integer studentAge;

    /**
    * 学生年级ID
    */
    @ApiModelProperty(value="学生年级ID")
    private String studentGrade;

    /**
    * 学生年级name
    */
    @ApiModelProperty(value="学生年级name")
    private String studentGradeName;

    /**
    * 学生班级ID
    */
    @ApiModelProperty(value="学生班级ID")
    private String studentClass;

    /**
    * 学生班级name
    */
    @ApiModelProperty(value="学生班级name")
    private String studentClassName;

    /**
    * 学生电子邮件
    */
    @ApiModelProperty(value="学生电子邮件")
    private String studentEmail;

    /**
    * 学生状态
    */
    @ApiModelProperty(value="学生状态")
    private String studentStatus;

    /**
    * 学生生日
    */
    @ApiModelProperty(value="学生生日")
    private String studentBirthday;

    /**
    * 学生家庭住址
    */
    @ApiModelProperty(value="学生家庭住址")
    private String studentAddress;

    /**
    * 学生电话
    */
    @ApiModelProperty(value="学生电话")
    private String studentPhone;

    /**
    * 学生监护人ID
    */
    @ApiModelProperty(value="学生监护人ID")
    private String studentGuardianId;

    /**
    * 学生监护人姓名
    */
    @ApiModelProperty(value="学生监护人姓名")
    private String studentGuardianName;

    /**
    * 学生监护人电话
    */
    @ApiModelProperty(value="学生监护人电话")
    private String studentGuardianPhone;

    /**
    * 学生监护人关系
    */
    @ApiModelProperty(value="学生监护人关系")
    private String studentGuardianRelationship;

    /**
    * 学生入学时间
    */
    @ApiModelProperty(value="学生入学时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date studentAdmissionTime;

    /**
    * 学生毕业时间
    */
    @ApiModelProperty(value="学生毕业时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date studentLeaveTime;

    /**
    * 学生户籍地
    */
    @ApiModelProperty(value="学生户籍地")
    private String studentRegisteredResidence;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
    * 创建人
    */
    @ApiModelProperty(value="创建人")
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
    * 更新人
    */
    @ApiModelProperty(value="更新人")
    private String updateBy;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    /**
    * 删除人
    */
    @ApiModelProperty(value="删除人")
    private String deleteBy;

    /**
    * 删除时间
    */
    @ApiModelProperty(value="删除时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deleteTime;

    /**
    * 删除状态
    */
    @ApiModelProperty(value="删除状态")
    private Boolean deleteStatus;

    private static final long serialVersionUID = 1L;
}