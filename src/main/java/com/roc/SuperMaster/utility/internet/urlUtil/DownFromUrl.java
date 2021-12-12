package com.roc.SuperMaster.utility.internet.urlUtil;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/12/12 20:39
 * @ClassName DownFromUrl.class
 * @Description 通过URL下载图片
 * @UpdateUser Roc
 */
public class DownFromUrl {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://pic.cnblogs.com/avatar/2157769/20200917085607.png");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/roc/SuperMaster/utility/internet/urlUtil/targetPicture.png");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,bytes.length);
        }
        fileOutputStream.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}