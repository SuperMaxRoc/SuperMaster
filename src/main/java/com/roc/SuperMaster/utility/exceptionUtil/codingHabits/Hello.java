package com.roc.SuperMaster.utility.exceptionUtil.codingHabits;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author Roc
 * @Date 2021/12/13 9:44
 * @Version 1.0.0
 * @ClassName Hello.java
 * @Description 对比Try-catch-finally和Try-with-resource
 * @UpdateUser Roc
 */
public class Hello {
    /**
     * 传统的Try-catch-finally
     */
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket();
            outputStream = socket.getOutputStream();
            String str = "你好";
            outputStream.write(str.getBytes(), 0, str.getBytes().length);
            System.out.println(outputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用Try-with-resource
     */
    public void testTryWithResource() {
        try (
                Socket socket = new Socket();
                OutputStream outputStream = socket.getOutputStream();
        ) {
            String str = "你好";
            outputStream.write(str.getBytes(), 0, str.getBytes().length);
            System.out.println(outputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
