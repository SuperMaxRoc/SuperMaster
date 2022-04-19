package com.roc.SuperMaster.utility.lambda.pojo;

import com.roc.SuperMaster.entity.domain.Guardian;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String id;

    private String name;

    private int age;

    private Guardian guardian;

}
