package com.roc.SuperMaster.utility.internet.tcpCS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 13:40
 * @ClassName TcpServerGetFile.class
 * @Description Tcp服务端接受文件
 * @UpdateUser Roc
 */
public class TcpServerGetFile {
    public static void main(String[] args) throws Exception{
        //创建接收连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //接收连接监听发送连接
        Socket accept = serverSocket.accept();
        //从发送连接中获取字节流
        InputStream inputStream = accept.getInputStream();
        //创建用于写出文件的文件字节流
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/java/com/roc/SuperMaster/utility/internet/tcpCS/target02.jpg"));

        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer,0,len);
        }

        //接收完毕，通知客户端
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("服务器接收完毕，可以断开连接".getBytes());

        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}