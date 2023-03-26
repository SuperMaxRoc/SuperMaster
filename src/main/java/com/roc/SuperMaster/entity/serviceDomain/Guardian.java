package com.roc.SuperMaster.entity.serviceDomain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Guardian
 * @Description 用于测试Http调用
 * @Author Roc
 * @date 2022/4/5 14:13
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guardian implements Serializable {

    private static final long serialVersionUID = 1L;

    private String guardianId;

    /**
     * 监护人姓名
     */
    private String guardianName;

    /**
     * 监护人学号
     */
    private String guardianNumber;

    /**
     * 监护人身份证
     */
    private String guardianCardId;

    /**
     * 监护人性别
     */
    private String guardianSex;

    /**
     * 监护人年龄
     */
    private Integer guardianAge;

    /**
     * 监护人家庭住址
     */
    private String guardianAddress;

    /**
     * 监护人户籍地
     */
    private String guardianRegisteredResidence;

    /**
     * 监护人电话
     */
    private String guardianPhone;

    /**
     * 被监护学生Id
     */
    private String guardianStudentId;

    /**
     * 被监护学生name
     */
    private String guardianStudentName;

    /**
     * 监护人与被监护人关系
     */
    private String guardianGuardianRelationship;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除人
     */
    private String deleteBy;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 删除状态
     */
    private Boolean deleteStatus;

    //数据库中不存在的字段
    @TableField(exist = false)
    @ApiModelProperty(value = "创建时间Ge")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTimeGe;

    @TableField(exist = false)
    @ApiModelProperty(value = "创建时间Le")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTimeLe;

}
