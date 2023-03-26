package com.roc.SuperMaster.utility.internet.tcpCS;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 13:38
 * @ClassName TcpClientToFile.class
 * @Description TCP客户端实现文件上传
 * @UpdateUser Roc
 */
public class TcpClientUploadFile {
    public static void main(String[] args) throws Exception {
        //创建服务器地址：本机
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 9999;
        //创建socket客户端
        Socket socket = new Socket(inetAddress, port);
        File file = new File("src/main/java/com/roc/SuperMaster/utility/internet/tcpCS/target01.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = socket.getOutputStream();
        byte[] buffer01 = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buffer01)) != -1) {
            outputStream.write(buffer01, 0, len);
        }

        //禁用此套接字的输出流。
        socket.shutdownOutput();

        //开始接受来自服务端的通知
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer02 = new byte[1024];
        int len02 = 0;
        while ((len02 = inputStream.read(buffer02)) != -1) {
            byteArrayOutputStream.write(buffer02, 0, len02);
        }
        System.out.println(byteArrayOutputStream.toString());

        byteArrayOutputStream.close();
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }
}