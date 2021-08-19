package com.roc.SuperMaster.web.testEverything;

import com.roc.SuperMaster.utility.desUtils.Md5Util;
import com.roc.SuperMaster.utility.desUtils.Sha256HexUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/7/13 17:32
 */
@Api(tags = "测试一切")
@Slf4j
@RequestMapping("/testEverything")
@RestController
public class TestController {

    /**
     * 测试Sha256加密算法
     *
     * @param targetParam
     */
    @ApiOperation(value = "测试Sha256加密算法")
    @PostMapping("/getSha256Hex")
    public void getSha256(
            @RequestParam(value = "targetParam", defaultValue = "891ad0bd45444c33b8982d14476fd410") String targetParam
    ) {
        String sha256 = Sha256HexUtil.getSHA256(targetParam);
        System.out.println("sha256加密后：" + sha256);
    }

    /**
     * 测试MD5加密算法
     *
     * @param targetParam
     */
    @ApiOperation(value = "测试MD5加密算法")
    @GetMapping("/getMd5")
    public void getMd5(
            @RequestParam(value = "param", defaultValue = "MD") String targetParam
    ) {
        String md5 = Md5Util.MD5(targetParam);
        System.out.println("MD5加密后：" + md5);
    }

    /**
     * 测试数组拼接
     *
     * @param superList
     */
    @ApiOperation(value = "测试数组拼接")
    @GetMapping("/getSuperList")
    public void getSuperList(
            @RequestParam(required = false) List<String> superList
    ) {
        //list数组中添加固定的值
        superList.add("www.baidu.com");
        superList.add("www.360buy.com");
        //采用stringBuffer进行拼接
        StringBuffer stringInBuffer = new StringBuffer();
        //循环取出list中的元素
        for (int i = 0; i < superList.size(); i++) {
            String listData = superList.get(i);
//            if (i == 0){
//                stringInBuffer.append("domain=" + listData);
//            }else {
//                stringInBuffer.append("&domain="+ listData);
//            }
            stringInBuffer.append(listData);
        }
        String bufferToString = stringInBuffer.toString();
        System.out.println("拼接好的数据：" + bufferToString);
        System.out.println("直接打印数组list接收到的数据：" + superList);
    }

    //强制停止报错
    @Test
    public void testErrorMassage() {
        log.info("开始测试");
        try {
            int i = 1;
            int b = 0;
            System.out.println(i / b);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("异常信息：{}", e.getMessage());
        }
    }

    @Test
    public void testMap() {
        Map<String, String> objectObjectMap = new HashMap<>();
        objectObjectMap.put("AH", "df");
        objectObjectMap.put("H", "df");
        objectObjectMap.put("zH", "df");
        System.out.println(objectObjectMap);
    }

    @Test
    public void testLength(){
        String string = "B03A05A02A04";
        System.out.println(string.length());
        String substring = string.substring(1, 3);
        System.out.println(substring);
    }

}