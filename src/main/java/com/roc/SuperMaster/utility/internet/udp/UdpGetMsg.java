package com.roc.SuperMaster.utility.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 14:53
 * @ClassName UdpGetMsg.class
 * @Description UDP协议接收消息：接收端
 * @UpdateUser Roc
 */
public class UdpGetMsg {

    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0, bytes.length));
        datagramSocket.close();
    }
}
