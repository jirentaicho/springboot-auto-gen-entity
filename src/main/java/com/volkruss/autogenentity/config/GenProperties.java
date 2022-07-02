package com.volkruss.autogenentity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/gensetting.properties")
public class GenProperties {
    @Autowired
    private Environment environment;

    public String get(String key){
        return environment.getProperty(key);
    }
}
