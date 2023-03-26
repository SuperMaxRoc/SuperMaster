package com.roc.SuperMaster.service;

/**
 * @Author Roc
 * @Date 2021/8/25 10:58
 * @Version 1.0.0
 * @ClassName ParseIdCardService.java
 * @Description IDCard解析服务
 * @UpdateUser Roc
 */
public interface ParseIdCardService {

    //验证IDCard合法性
    boolean parseIdCard(String idCard);

    //解析PCA
    String parsePCA(String code);

    //解析Age
    int parseAge(String substringToBirth);

    //解析生日
    String parseBirth(String substringToBirth);

    //解析性别
    String parseSex(String substringToSex);

}
