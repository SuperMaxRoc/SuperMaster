package com.roc.SuperMaster.service.impl;

import com.roc.SuperMaster.service.PcaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: WP
 * @Date: 2021/8/23 22:51
 * @Version 1.0
 * @ClassName ParseIdCardService.java
 * @Description 解析身份证，获得省市区、年龄、生日、性别
 * @UpdateUser WP
 */
@Slf4j
@Service
public class ParseIdCardService {

    @Autowired
    PcaService pcaService;

    public String parseIdCard(
            String idCard
    ) {
        int length = idCard.length();
        if (length == 18) {
            return "IDCard合法";
        } else {
            log.error("IDCard非法");
            return null;
        }
    }

    public String parsePCA(
            String code
    ) {
        String pcaNameByCode = pcaService.getPcaNameByCode(code);
        if (pcaNameByCode == null) {
            log.error("无法解析PCA，请输入正确的身份证号码");
            return null;
        } else {
            return pcaNameByCode;
        }
    }

    public String parseAge(
            String substringToBirth
    ) {
        Date date = new Date();
        String dateFormat = "yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        int nowYear = Integer.parseInt(simpleDateFormat.format(date).toString());
        int oldBirthYear = Integer.parseInt(substringToBirth.substring(0, 4));
        int age = nowYear - oldBirthYear;
        if (age >= 1 & age <= 100) {
            return String.valueOf(age);
        } else {
            log.error("年龄解析不合法，请输入正确的身份证号码");
            return null;
        }
    }

    public String parseBirth(
            String substringToBirth
    ) {
        String parseAge = this.parseAge(substringToBirth);
        if (parseAge == null) {
            log.error("生日解析不合法，请输入正确的身份证号码");
            return null;
        } else {
            String year = substringToBirth.substring(0, 4);
            String month = substringToBirth.substring(4, 6);
            String day = substringToBirth.substring(6, 8);
            StringBuilder stringBuilder = new StringBuilder();
            String string = stringBuilder.append(year).append("-").append(month).append("-").append(day).toString();
            return string;
        }
    }

    public String parseSex(
            String substringToSex
    ) {
        //StringUtils.isNumeric() 方法:isNumeric() 可以判断 字符串是否为数字字符串，即只能判断纯数字字符串
        if (StringUtils.isNumeric(substringToSex)){
            int i = Integer.parseInt(substringToSex);
            if (i % 2 == 0) {
                return "女";
            } else {
                return "男";
            }
        }else {
            log.error("性别解析不合法，请输入正确的身份证号");
            return null;
        }
    }
}
