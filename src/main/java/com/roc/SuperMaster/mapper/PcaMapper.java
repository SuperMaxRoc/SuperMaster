package com.roc.SuperMaster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roc.SuperMaster.entity.serviceDomain.Pca;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: WP
 * @Date: 2021/8/23 22:48
 * @Version 1.0
 * @ClassName PcaMapper.java
 * @Description PcaMapper
 * @UpdateUser WP
 */
@Mapper
public interface PcaMapper extends BaseMapper<Pca> {
    int deleteByPrimaryKey(Long pcaId);

    int insert(Pca record);

    int insertSelective(Pca record);

    Pca selectByPrimaryKey(Long pcaId);

    int updateByPrimaryKeySelective(Pca record);

    int updateByPrimaryKey(Pca record);

    //根据Code获取PcaName
    String getPcaNameByCode(String code);
}