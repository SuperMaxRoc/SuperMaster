package com.roc.SuperMaster.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roc.SuperMaster.entity.domain.Pca;
import com.roc.SuperMaster.mapper.PcaMapper;
import com.roc.SuperMaster.service.PcaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: WP
 * @Date: 2021/8/23 22:48
 * @Version 1.0
 * @ClassName PcaServiceImpl.java
 * @Description ToDo
 * @UpdateUser WP
 */
@Service
public class PcaServiceImpl extends ServiceImpl<PcaMapper,Pca> implements PcaService {

    @Resource
    private PcaMapper pcaMapper;

    @Override
    public int deleteByPrimaryKey(Long pcaId) {
        return pcaMapper.deleteByPrimaryKey(pcaId);
    }

    @Override
    public int insert(Pca record) {
        return pcaMapper.insert(record);
    }

    @Override
    public int insertSelective(Pca record) {
        return pcaMapper.insertSelective(record);
    }

    @Override
    public Pca selectByPrimaryKey(Long pcaId) {
        return pcaMapper.selectByPrimaryKey(pcaId);
    }

    @Override
    public int updateByPrimaryKeySelective(Pca record) {
        return pcaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pca record) {
        return pcaMapper.updateByPrimaryKey(record);
    }

    @Override
    public String getPcaNameByCode(String code){
        return pcaMapper.getPcaNameByCode(code);
    }

}
