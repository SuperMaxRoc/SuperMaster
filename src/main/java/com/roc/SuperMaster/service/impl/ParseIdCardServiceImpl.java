package com.roc.SuperMaster.service.impl;

import com.roc.SuperMaster.service.ParseIdCardService;
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
 * @ClassName ParseIdCardServiceImpl.java
 * @Description 解析身份证，获得省市区、年龄、生日、性别
 * @UpdateUser WP
 */
@Slf4j
@Service
public class ParseIdCardServiceImpl implements ParseIdCardService {

    @Autowired
    PcaService pcaService;

    /**
     * @param idCard
     * @return java.lang.String
     * @Author: WP
     * @Date: 2021/9/3 14:01
     * @Version 1.0
     * @Description: 获取PCA代码
     * @UpdateUser WP
     */
    public String getStringToPCA(
            String idCard
    ) {
        String substringToPCA = idCard.substring(0, 6);
        return substringToPCA;
    }

    /**
     * @param idCard
     * @return java.lang.String
     * @Author: WP
     * @Date: 2021/9/3 14:01
     * @Version 1.0
     * @Description: 获取BirthAndAge代码
     * @UpdateUser WP
     */
    public String getStringToBirthAndAge(
            String idCard
    ) {
        String substringToBirthAndAge = idCard.substring(6, 14);
        return substringToBirthAndAge;
    }

    /**
     * @param idCard
     * @return java.lang.String
     * @Author: WP
     * @Date: 2021/9/3 14:02
     * @Version 1.0
     * @Description: 获取Sex代码
     * @UpdateUser WP
     */
    public String getStringToSex(
            String idCard
    ) {
        String substringToToSex = idCard.substring(16, 17);
        return substringToToSex;
    }

    @Override
    public boolean parseIdCard(
            String idCard
    ) {
        //目前仅验证了IDCard的长度
        int length = idCard.length();
        if (length == 18) {
            log.info("IDCard合法");
            return true;
        } else {
            log.error("IDCard非法");
            return false;
        }
    }

    @Override
    public String parsePCA(
            String idCard
    ) {
        String stringToPCA = this.getStringToPCA(idCard);
        String pcaNameByCode = pcaService.getPcaNameByCode(stringToPCA);
        if (pcaNameByCode == null) {
            log.error("无法解析PCA，请输入正确的身份证号码");
            int a = 1 / 0;
            return null;
        } else {
            return pcaNameByCode;
        }
    }

    @Override
    public int parseAge(
            String idCard
    ) {
        String stringToBirthAndAge = this.getStringToBirthAndAge(idCard);
        Date date = new Date();
        String dateFormat = "yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        //获取当前年份
        int nowYear = Integer.parseInt(simpleDateFormat.format(date).toString());
        //获取IDCard年份
        int oldBirthYear = Integer.parseInt(stringToBirthAndAge.substring(0, 4));
        int age = nowYear - oldBirthYear;
        if (age >= 1 & age <= 100) {
            return age;
        } else {
            log.error("年龄解析不合法，请输入正确的身份证号码");
            int a = 1 / 0;
            return 0;
        }
    }

    @Override
    public String parseBirth(
            String idCard
    ) {
        String stringToBirthAndAge = this.getStringToBirthAndAge(idCard);
        int parseAge = this.parseAge(idCard);
        if (parseAge == 0) {
            log.error("生日解析不合法，请输入正确的身份证号码");
            int a = 1 / 0;
            return null;
        } else {
            String year = stringToBirthAndAge.substring(0, 4);
            String month = stringToBirthAndAge.substring(4, 6);
            String day = stringToBirthAndAge.substring(6, 8);
            StringBuilder stringBuilder = new StringBuilder();
            String string = stringBuilder.append(year).append("-").append(month).append("-").append(day).toString();
            return string;
        }
    }

    @Override
    public String parseSex(
            String idCard
    ) {
        //StringUtils.isNumeric() 方法:isNumeric() 可以判断 字符串是否为数字字符串，即只能判断纯数字字符串
        String stringToSex = this.getStringToSex(idCard);
        if (StringUtils.isNumeric(stringToSex)) {
            int i = Integer.parseInt(stringToSex);
            if (i % 2 == 0) {
                return "女";
            } else {
                return "男";
            }
        } else {
            log.error("性别解析不合法，请输入正确的身份证号");
            int a = 1 / 0;
            return null;
        }
    }
}
