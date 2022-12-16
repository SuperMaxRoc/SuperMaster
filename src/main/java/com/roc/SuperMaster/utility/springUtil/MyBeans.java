package com.roc.SuperMaster.utility.springUtil;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @ClassName MyBeans
 * @Description TODO
 * @Author WangPeng
 * @date 2022/12/16 16:14
 * @Version 1.0
 */
@Configuration
public class MyBeans {

    @Bean("DefaultRestTemplate")
    public RestTemplate getDefaultRestTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(1));
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate;
    }

}
