package com.cumt.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.WebLogicJtaTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018-05-15.
 */
@Configuration
public class Config extends WebMvcConfigurationSupport {
    public void getRequestMappingHandlerMapping(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new MetaDataResolver());
    }
}