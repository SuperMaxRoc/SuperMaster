package com.roc.SuperMaster.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.roc.SuperMaster.entity.domain.Pca;

/**
 * @Author: WP
 * @Date: 2021/8/23 22:48
 * @Version 1.0
 * @ClassName PcaService.java
 * @Description 基础的PCA服务
 * @UpdateUser WP
 */
public interface PcaService extends IService<Pca> {

    int deleteByPrimaryKey(Long pcaId);

    int insert(Pca record);

    int insertSelective(Pca record);

    Pca selectByPrimaryKey(Long pcaId);

    int updateByPrimaryKeySelective(Pca record);

    int updateByPrimaryKey(Pca record);

    //根据PCACode获取PCAName
    String getPcaNameByCode(String code);

}
