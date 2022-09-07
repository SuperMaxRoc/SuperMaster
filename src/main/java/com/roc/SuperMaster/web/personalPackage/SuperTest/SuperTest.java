package com.roc.SuperMaster.web.personalPackage.SuperTest;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Time;
import java.util.Date;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.roc.SuperMaster.entity.serviceDomain.Students;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.util.StringUtil;
import org.junit.Test;
import org.springframework.web.util.UriBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.roc.SuperMaster.utility.timeUtil.TimeUtil.convertStartPlusEndToDate;

/**
 * @Author: WP
 * @Date: 2021/8/8 23:03
 * @Version 1.0
 * @ClassName TestChar.java
 * @Description testChar
 * @UpdateUser WP
 */
public class SuperTest {

    @Test
    public void testChar() {
        char uniChar = 0x0041;
        System.out.println(uniChar);
        Integer integer = 55;
        String s = "A";
        System.out.println(s);
        System.out.println(UUID.randomUUID());
        String string = " ";
        if (StringUtils.isBlank(string)) {
            System.out.println("是空白");
        } else {
            System.out.println("不是空白");
        }
    }

    @Test
    public void testList() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        strings.add("11");
        strings.add("10");
        strings.add(String.valueOf(1));
        strings.forEach(s -> System.out.println(s));
        long count = strings.stream().count();
        System.out.println(count);
        ListIterator<String> stringListIterator = strings.listIterator();

        for (String string : strings) {
            System.out.println(string);
        }
        strings.forEach(s -> System.out.println(s));

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
        Map<String, String> map = new HashMap<>();
        map.put("01", "02");
        map.forEach((k, v) -> System.out.println(k + v));
        int size = map.size();
        System.out.println(map.get(""));

        List<Object> list = new ArrayList<>();
        list.add(1);

        list.add("adb");
        System.out.println(list);
    }

    @Test
    public void testStingFormat() {
        //System.out.println(String.format("订单:%s获取工单库位失败", "test"));
        Date date = new Date();
        String daemon = "2022-05-16 23:59:59";
        System.out.println(convertStartPlusEndToDate(date.toString(), 60));
        System.out.println(convertStartPlusEndToDate(daemon, 60));
    }

    @Test
    public void testament() {
        String[] strings = {"","123","   "};
        for (String string : strings) {
            if (org.apache.commons.lang3.StringUtils.isBlank(string)) {
                System.out.println("这是一个空空kong值");
            }else {
                System.out.println("这不是一个空空值");
            }
        }
    }

    /**
     * String.format
     */
    @Test
    public  void testStringFormat(){
        System.out.printf("%s,123%s，%s%n","ssss","qqq","www");
    }

    @Test
    public void testString(){
        ArrayList<Students> students = new ArrayList<>();
        students.add(new Students());
        JSONArray objects = JSONArray.parseArray(JSON.toJSONString(students));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("", students);

        System.out.println(jsonObject);
    }

    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * UrlBuilder
     */
    @Test
    public void testURLBuilder(){
        String url = new UrlBuilder().setScheme("https")
                .setHost("192.168.0.0")
                .setPort(9999)
                .addPath("/test/urlBuilder")
                .addQuery("orderId", "123").build();
        System.out.println(url);
    }

    @Test
    public void subString(){
        String target ="GA0T720000032N5LRTZE";

        if (target.length() > 20) {
            target = target.substring(0, 13);
        } else {
            target = target.substring(0, 11);
        }
        System.out.println(target);
    }

    @Test
    public void subList(){
        double abacus = (double) 14;
        double babble = 20.0;
        System.out.println((int)(Math.ceil(abacus/babble)));
        System.out.println(1<2.0);
    }

    @Test
    public void testMathCeil() {
        ArrayList<String>       list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        int serviceCodeListen = 1;
        int pageSize = 20;
        int pageNum =   1;
        int pageStartIndex;
        if ((int) (Math.ceil((double) serviceCodeListen / (double) pageSize)) < pageNum) {
            pageStartIndex = ((int) (Math.ceil((double) serviceCodeListen / (double) pageSize) - 1) * pageSize);
        } else {
            pageStartIndex = ((pageNum - 1) * pageSize);
        }
        System.out.println(pageStartIndex);
        System.out.println(list.subList(pageStartIndex, 2));
    }

    @Test
    public void testReplace(){
        String phone = "15612345678";
        System.out.println(phone.length());
        if (phone.length() == 11){
            System.out.println(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        }
    }
    @Test
    public void testSubString(){
        String phone = "山东省德州市";
        //System.out.println(phone.replace(phone.substring(3), "****************"));
        System.out.println((int)Math.floor(0.0));
        System.out.println((int)Math.floor(2.7));
        System.out.println((int)Math.floor(2.1));
    }

}
