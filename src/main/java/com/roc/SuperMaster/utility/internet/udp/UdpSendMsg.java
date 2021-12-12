package com.roc.SuperMaster.utility.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 14:46
 * @ClassName UdpSendMsg.class
 * @Description UDP协议发送信息：发送端
 * @UpdateUser Roc
 */
public class UdpSendMsg {

    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 9999;
        byte[] bytes = "你好".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,inetAddress,port);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

}
