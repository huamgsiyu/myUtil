package com.syh.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * RestTemplateAsyncConfig
 *  异步RestTemplate配置
 * @author HSY
 * @since 2020/05/21 23:06
 */
@Configuration
public class RestTemplateAsyncConfig {
    @Bean
    public AsyncRestTemplate asyncRestTemplate(){
        return new AsyncRestTemplate();
    }

    public AsyncClientHttpRequestFactory clientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setReadTimeout(5000);
        return factory;

    }
}
