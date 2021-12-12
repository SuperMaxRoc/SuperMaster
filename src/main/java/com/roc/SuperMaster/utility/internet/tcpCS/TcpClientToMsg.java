package com.roc.SuperMaster.utility.internet.tcpCS;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author Roc
 * @Date 2021/12/10 17:34
 * @Version 1.0.0
 * @ClassName TcpClientToMsg.java
 * @Description TCP客户端发送消息
 * @UpdateUser Roc
 */
public class TcpClientToMsg {

    public static void main(String[] args) throws Exception {
        //获得目标服务端的IP
        InetAddress serverIp = InetAddress.getByName("localhost");
        int port = 9999;
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            //创建客户端
            socket = new Socket(serverIp, port);
            //将发送的消息处理成客户端的输出流
            outputStream = socket.getOutputStream();
            outputStream.write("你好，世界".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            socket.close();
        }
    }
}