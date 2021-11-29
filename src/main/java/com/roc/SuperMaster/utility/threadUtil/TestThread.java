package com.roc.SuperMaster.utility.threadUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Roc
 * @Date 2021/11/29 17:51
 * @Version 1.0.0
 * @ClassName TestThread.java
 * @Description ToDo
 * @UpdateUser Roc
 */
@Slf4j
public class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
