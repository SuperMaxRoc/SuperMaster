package com.roc.SuperMaster.utility.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 15:09
 * @ClassName UdpLoopGetMsg.class
 * @Description UDP循环接收消息
 * @UpdateUser Roc
 */
public class UdpLoopGetMsg {
    public static void main(String[] args) throws Exception {

        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];

        while (true) {

            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            datagramSocket.receive(datagramPacket);
            String s = new String(datagramPacket.getData(), 0, datagramPacket.getData().length);
            System.out.println(s);
            bytes = new byte[1024];
            if (s.equals("bye")){
                break;
            }
        }
        datagramSocket.close();
    }
}
