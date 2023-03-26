package com.roc.SuperMaster.utility.jsonUtil;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.roc.SuperMaster.entity.systemDomain.User;
import lombok.var;
import org.junit.Test;

/**
 * @ClassName GsonUtil
 * @Description GsonUtil
 * @Author Roc
 * @date 2022/4/5 10:55
 * @Version 1.0
 */
public class GsonUtil {

    @Test
    public void formatPrint() {

        String json = JSON.toJSONString(new User() {{
            setId("ID001");
            setName("Roc");
        }});

        System.out.println("-----------------------------------------------");
        System.out.println("未格式化的：" + json);

        System.out.println("-----------------------------------------------");
        var user = new User() {{
            setId(null);
            setName("nihao");
        }};

        //使用Alibaba的FastJson格式化输出普通对象，有null值等情况
        String s = JSON.toJSONString(
                user,
                //格式化输出
                SerializerFeature.PrettyFormat,
                //输出为null的字段
                //SerializerFeature.WriteMapNullValue,
                //按字段名称排序后输出
                SerializerFeature.SortField
                ////数值字段如果为null，输出0，而非null
                //SerializerFeature.WriteNullNumberAsZero,
                ////Boolean字段如果为null,输出为false,而非null
                //SerializerFeature.WriteNullBooleanAsFalse
        );
        System.out.println("使用Alibaba的FastJson格式化输出普通对象(可过滤null值):\n" + s);
        System.out.println("-----------------------------------------------");

        //使用Gson对Alibaba的JSONObject对象格式化输出
        System.out.println("使用Gson对Alibaba的JSONObject对象格式化输出:\n" + new GsonBuilder().setPrettyPrinting().create().toJson(JSONObject.parseObject(json)));

        System.out.println("-----------------------------------------------");
        User user001 = new User() {{
            setId("");
            setName("nihao");
        }};
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(user001));
        for (String string : jsonObject.keySet()) {
            if (ObjectUtil.isEmpty(jsonObject.getString(string))) {
                jsonObject.remove(string);
            }
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("使用Gson对Alibaba的JSONObject对象格式化输出(可过滤空值):\n" + gson.toJson(jsonObject));
    }

}
