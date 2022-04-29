package com.roc.SuperMaster.entity.systemDomain;

import com.roc.SuperMaster.entity.serviceDomain.Guardian;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/9/13 22:11
 * @ClassName User.class
 * @Description 用于配合测试SuperLambda的用户类
 * @UpdateUser Roc
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /**
     * id
     */
    //@NotNull(value = "id不能为空")
    private String id;

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private int age;

    /**
     * id
     */
    private Guardian guardian;

}
