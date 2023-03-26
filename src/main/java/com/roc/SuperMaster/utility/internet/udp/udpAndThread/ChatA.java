package com.roc.SuperMaster.utility.internet.udp.udpAndThread;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 20:26
 * @ClassName ChatA.class
 * @Description 聊天者A
 * @UpdateUser Roc
 */
public class ChatA {
    public static void main(String[] args) {
        new Thread(new SentThread(9999, "localhost", 7777)).start();
        new Thread(new ReceiveThread("ChatB", 8888)).start();
    }
}