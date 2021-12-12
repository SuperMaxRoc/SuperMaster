package com.roc.SuperMaster.utility.internet.udp.udpAndThread;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 20:02
 * @ClassName Receive.class
 * @Description Udp在线聊天：接收方法
 * @UpdateUser Roc
 */
public class ReceiveThread implements Runnable {

    //数据报：用于解析发来的数据报实例
    DatagramSocket datagramSocket;
    DatagramPacket datagramPacket;

    private String fromID;
    private int port;

    public ReceiveThread(String fromID, int port) {
        this.fromID = fromID;
        this.port = port;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //构建数据报
                byte[] bytes = new byte[1024];
                datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
                //接收数据报信息
                datagramSocket.receive(datagramPacket);
                //获取数据报的数据，然后解析
                byte[] data = datagramPacket.getData();
                String msg = new String(data, 0, data.length);
                System.out.println(fromID + ":" + msg);
                if (msg.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}