package com.roc.SuperMaster.utility.internet.udp.udpAndThread;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 20:27
 * @ClassName ChatB.class
 * @Description 聊天者B
 * @UpdateUser Roc
 */
public class ChatB {
    public static void main(String[] args) {
        new Thread(new SentThread(8888,"localhost",5555)).start();
        new Thread(new ReceiveThread("ChatA",9999)).start();
    }
}
