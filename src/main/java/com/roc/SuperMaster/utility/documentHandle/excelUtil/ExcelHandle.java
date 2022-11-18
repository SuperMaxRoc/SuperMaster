package com.roc.SuperMaster.utility.documentHandle.excelUtil;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.util.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Author Roc
 * @Date 2021/9/1 17:46
 * @Version 1.0.0
 * @ClassName ExcelHandle.java
 * @Description Office-excel处理
 * @UpdateUser Roc
 */
public class ExcelHandle {

    @Test
    public void testament() {
        //ArrayList<JSONObject> jsonObjects = new ArrayList<>();
        //HashMap<String, JSONObject> hashMap = new HashMap<>();
        //RestTemplate restTemplate = new RestTemplate();
        //HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
        //HashMap<String, String> map = new HashMap<>();
        //map.put("CQT2208133244BGA", "WO1");
        //map.put("QD19030900000002", "WO1");
        //HttpEntity<String> httpEntity = new HttpEntity<>(JSONObject.toJSONString(map), httpHeaders);
        //ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:7088/dashboardForInfo/estimateFee", httpEntity, String.class);
        //if (responseEntity.getStatusCode() == HttpStatus.OK) {
        //    if (JSONObject.parseObject(responseEntity.getBody()) != null) {
        //        for (String s : map.keySet()) {
        //            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        //            hashMap.put(s,jsonObject.getJSONObject(s));
        //        }
        //    }
        //}
        //System.out.println(hashMap);
        //DecimalFormat decimalFormat = new DecimalFormat("0.00");
        //System.out.println(decimalFormat.format(10099.12 / 10000));
        //ArrayList<JSONObject> jsonObjects = new ArrayList<JSONObject>() {{
        //    add(new JSONObject() {{
        //        put("1", "123");
        //    }});
        //    add(new JSONObject() {{
        //        put("1", "234");
        //    }});
        //    add(new JSONObject() {{
        //        put("2", "234");
        //    }});
        //}};
        //Map<String, String> collect = jsonObjects.stream().distinct().collect(Collectors.toMap(p->p.toString(), p -> p.getString("123")));
        //System.out.println(collect);
        //
        //System.out.println(jsonObjects.stream().collect(Collectors.toList()));
        //System.out.println(jsonObjects.stream().map(p -> p.getString("1")).distinct().collect(Collectors.toList()));

        //System.out.println(long01/abacus);

        //long long01 = 123L;
        //int abacus = 123;
        //System.out.println(percent(Double.parseDouble(String.valueOf(long01 / abacus))));

        //HashMap<String, String> hashMap = new HashMap<String, String>() {{
        //    put("all", "0");
        //    put("2", "0");
        //    put("3", "0");
        //    put("4", "0");
        //}};
        //hashMap.remove("all");
        //System.out.println(new ArrayList<>(hashMap.keySet()));
        //System.out.println(getPercent(3,6));
        System.out.println(head());
    }

    public static String formatDateTimeFormDateStringPlus(Date date, String pattern) {
        /**
         * 示例：
         * pattern：yyyy-MM-dd 00:00:00
         * 出参：2022-10-10 00:00:00
         */
        if (date == null || StringUtils.isBlank(pattern)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static Date getDateByRange(Date date, String timeUnit, int range) {
        /**
         * 实例：
         * 入参date：2022-10-10 15:00:00
         * 入参范围：2
         * 入参单位：day
         *
         * 出参date：2022-10-08 15:00:00
         */
        Date targetDate = null;
        if (StringUtils.isBlank(date.toString()) || StringUtils.isBlank(timeUnit)) {
            return targetDate;
        }
        //处理
        if (StringUtils.isNotBlank(timeUnit) && "second".equals(timeUnit)) {
            targetDate = DateUtil.parse(String.valueOf(new Date(date.getTime() + (range * 1000L))));
        } else if (StringUtils.isNotBlank(timeUnit) && "minute".equals(timeUnit)) {
            targetDate = DateUtil.parse(String.valueOf(new Date(date.getTime() + (range * 60000L))));
        } else if (StringUtils.isNotBlank(timeUnit) && "hour".equals(timeUnit)) {
            targetDate = DateUtil.parse(String.valueOf(new Date(date.getTime() + (range * 1000 * 60 * 60L))));
        } else if (StringUtils.isNotBlank(timeUnit) && "day".equals(timeUnit)) {
            targetDate = DateUtil.parse(String.valueOf(new Date(date.getTime() + (range * 1000 * 60 * 60 * 24L))));
        } else {
            return targetDate;
        }
        return targetDate;
    }

    private List<List<String>> head() {
        List<List<String>> list = ListUtils.newArrayList();
        List<String> head01 = ListUtils.newArrayList();
        List<String> head02 = ListUtils.newArrayList();
        List<String> head03 = ListUtils.newArrayList();
        List<String> head04 = ListUtils.newArrayList();
        List<String> head05 = ListUtils.newArrayList();
        List<String> head06 = ListUtils.newArrayList();
        List<String> head07 = ListUtils.newArrayList();
        List<String> head08 = ListUtils.newArrayList();
        List<String> head09 = ListUtils.newArrayList();
        List<String> head10 = ListUtils.newArrayList();
        List<String> head11 = ListUtils.newArrayList();
        List<String> head12 = ListUtils.newArrayList();
        List<String> head13 = ListUtils.newArrayList();
        List<String> head14 = ListUtils.newArrayList();
        List<String> head15 = ListUtils.newArrayList();
        List<String> head16 = ListUtils.newArrayList();
        List<String> head17 = ListUtils.newArrayList();
        List<String> head18 = ListUtils.newArrayList();
        List<String> head19 = ListUtils.newArrayList();
        List<String> head20 = ListUtils.newArrayList();
        List<String> head21 = ListUtils.newArrayList();
        List<String> head22 = ListUtils.newArrayList();
        List<String> head23 = ListUtils.newArrayList();
        List<String> head24 = ListUtils.newArrayList();

        head01.add("排名");
        head01.add("排名");

        head02.add("单位");
        head02.add("单位");

        head24.add("趋势");
        head24.add("趋势");

        head03.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -7), "MM-dd"));
        head04.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -7), "MM-dd"));
        head05.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -7), "MM-dd"));

        head06.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -6), "MM-dd"));
        head07.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -6), "MM-dd"));
        head08.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -6), "MM-dd"));

        head09.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -5), "MM-dd"));
        head10.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -5), "MM-dd"));
        head11.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -5), "MM-dd"));

        head12.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -4), "MM-dd"));
        head13.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -4), "MM-dd"));
        head14.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -4), "MM-dd"));

        head15.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -3), "MM-dd"));
        head16.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -3), "MM-dd"));
        head17.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -3), "MM-dd"));

        head18.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -2), "MM-dd"));
        head19.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -2), "MM-dd"));
        head20.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -2), "MM-dd"));

        head21.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -1), "MM-dd"));
        head22.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -1), "MM-dd"));
        head23.add(formatDateTimeFormDateStringPlus(getDateByRange(new Date(), "day", -1), "MM-dd"));

        head03.add("单");
        head06.add("单");
        head09.add("单");
        head12.add("单");
        head15.add("单");
        head18.add("单");
        head21.add("单");

        head04.add("占比");
        head07.add("占比");
        head10.add("占比");
        head13.add("占比");
        head16.add("占比");
        head19.add("占比");
        head22.add("占比");

        head05.add("损失");
        head08.add("损失");
        head11.add("损失");
        head14.add("损失");
        head17.add("损失");
        head20.add("损失");
        head23.add("损失");

        list.add(head01);
        list.add(head02);
        list.add(head03);
        list.add(head04);
        list.add(head05);
        list.add(head06);
        list.add(head07);
        list.add(head08);
        list.add(head09);
        list.add(head10);
        list.add(head11);
        list.add(head12);
        list.add(head13);
        list.add(head14);
        list.add(head15);
        list.add(head16);
        list.add(head17);
        list.add(head18);
        list.add(head19);
        list.add(head20);
        list.add(head21);
        list.add(head22);
        list.add(head23);
        list.add(head24);
        return list;
    }

}
