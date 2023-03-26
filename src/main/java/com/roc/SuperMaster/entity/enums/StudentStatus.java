package com.roc.SuperMaster.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName StudentStatus
 * @Description 学生状态枚举
 * @Author Roc
 * @date 2022/4/17 11:00
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum StudentStatus {

    WaitEntrance("WaitEntrance", "待入学"),
    Entrance("Entrance", "入学"),
    UpGrade("UpGrade", "待升级"),
    StayGrade("StayGrade", "留级"),
    DownGrade("DownGrade", "降级"),
    Graduation("Graduation", "毕业"),
    Observation("Observation", "留校观察"),
    Discontinue("Discontinue", "辍学");

    private String statusKey;
    private String statusDesc;

}
