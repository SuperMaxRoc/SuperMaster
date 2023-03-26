package com.roc.SuperMaster.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName TeacherStatus
 * @Description 教师职业状态
 * @Author Roc
 * @date 2022/4/17 11:10
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum TeacherStatus {

    WaitEntry("WaitEntry", "待入职"),
    OnJob("OnJob", "在职"),
    ReviewAndObserve("ReviewAndObserve", "评级观察"),
    Quit("Quit", "离职");

    private String statusKey;
    private String statusDesc;

}
