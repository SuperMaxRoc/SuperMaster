package com.roc.SuperMaster.utility.internet.tcpCS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Roc
 * @Date 2021/12/10 17:35
 * @Version 1.0.0
 * @ClassName TcpServer01.java
 * @Description TCP服务端接收消息
 * @UpdateUser Roc
 */
public class TcpServerGetMsg {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        //创建一个字节数组输出流
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //创建服务端
            serverSocket = new ServerSocket(9999);
            //服务端监听等待连接的对象
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            //设置缓冲区
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            byteArrayOutputStream.close();
            inputStream.close();
            accept.close();
            serverSocket.close();
        }
    }
}
