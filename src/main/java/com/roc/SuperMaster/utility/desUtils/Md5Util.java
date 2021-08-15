package com.roc.SuperMaster.utility.desUtils;

import io.swagger.annotations.ApiModel;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/7/5 19:47
 */
@ApiModel(value = "MD5加密类")
public class Md5Util {

    public static String MD5(String str) {
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        return md5;
    }

    @Test
    public void testMD5() {
        System.out.println(Md5Util.MD5("SB"));
    }
}