package com.roc.SuperMaster.utility.internet.udp.udpAndThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 20:02
 * @ClassName SentThread.class
 * @Description Udp在线聊天：发送方法
 * @UpdateUser Roc
 */
public class SentThread implements Runnable {

    //用于发送的信息报和数据报套接字
    DatagramPacket datagramPacket;
    DatagramSocket datagramSocket;

    //目标IP
    private String toIP;
    //目标端口
    private int toPort;
    //用于发送的端口
    private int fromPort;

    //缓冲字符输入流：用于接收用户System.in的字符数据
    BufferedReader bufferedReader;

    String buffer;

    public SentThread(int toPort, String toIP, int fromPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        this.fromPort = fromPort;
        try {
            this.datagramSocket = new DatagramSocket(fromPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                buffer = bufferedReader.readLine();
                byte[] bufferBytes = buffer.getBytes();
                //将用户输入的字符数据转换为字节数据，通过数据报的构建方法，构建携带数据以及目标IP的数据报实例。
                datagramPacket = new DatagramPacket(bufferBytes, 0, bufferBytes.length, new InetSocketAddress(this.toIP, this.toPort));
                //套接字负责发送数据报
                datagramSocket.send(datagramPacket);
                if (buffer.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        datagramSocket.close();
    }
}
