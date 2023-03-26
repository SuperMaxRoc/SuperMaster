package com.roc.SuperMaster.utility.internet.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 15:08
 * @ClassName UdpLoopSendMsg.class
 * @Description UDP循环发送消息
 * @UpdateUser Roc
 */
public class UdpLoopSendMsg {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferedReader.readLine();
            InetAddress inetAddress = InetAddress.getByName("localhost");
            DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(), 0, s.getBytes().length, inetAddress, 9999);
            socket.send(datagramPacket);
            if (s.equals("bye")) {
                break;
            }
        }
        socket.close();
    }
}