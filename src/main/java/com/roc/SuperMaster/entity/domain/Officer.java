package com.roc.SuperMaster.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Officer
 * @Description 测试Spring BeanUtil的拷贝
 * @Author WangPeng
 * @date 2022/4/7 16:28
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Officer implements Serializable, Cloneable {

    private int id;

    private boolean isGuardian;

    private Guardian guardian;

    @Override
    public Officer clone() throws CloneNotSupportedException {
        return (Officer) super.clone();
    }
}
