package com.roc.SuperMaster.utility.httpComm;

import cn.hutool.core.convert.Convert;
import com.roc.SuperMaster.utility.webResult.WebApiResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: WP
 * @Date: 2021/8/30 20:57
 * @Version 1.0
 * @ClassName RestTemplate.java
 * @Description Spring封装的Http请求方法
 * @UpdateUser WP
 */
@Slf4j
@Api(tags = "RestTemplateClientComm")
@RestController
@RequestMapping("/RestTemplateClientComm")
public class RestTemplateClientComm {


    @Value("${SuperBase.GetUrl}")
    private String superBaseGetUrl;

    @Value("${SuperBase.PostUrl}")
    private String superBasePostUrl;

    /**
     * @param
     * @return com.roc.SuperMaster.utility.webResult.WebApiResult
     * @Author: WangPeng
     * @Date: 2022/4/5 14:21
     * @Description: ToDo
     */
    @GetMapping("/GetRequest")
    private WebApiResult testGetRequest() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WebApiResult> forEntity = restTemplate.getForEntity(superBaseGetUrl, WebApiResult.class);
        Object data = forEntity.getBody().getData();
        List list = Convert.toList(data);
        System.out.println(list.get(0));

        return null;
    }

}
