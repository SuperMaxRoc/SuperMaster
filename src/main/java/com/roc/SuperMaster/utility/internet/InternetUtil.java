package com.roc.SuperMaster.utility.internet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Roc
 * @Date 2021/9/1 10:22
 * @Version 1.0.0
 * @ClassName InternetUtil.java
 * @Description java网络相关的工具及方法
 * @UpdateUser Roc
 */
@Slf4j
public class InternetUtil {

    /**
     * @Author: WP
     * @Date: 2021/9/1 10:25
     * @Version 1.0
     * @Description: 获取本机IP地址及主机名称
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void getIPAddress(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostIPAddress = inetAddress.getHostAddress();
            String hostName = inetAddress.getHostName();
            System.out.println("本地IP地址：" + hostIPAddress);
            System.out.println("本地主机name：" + hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
