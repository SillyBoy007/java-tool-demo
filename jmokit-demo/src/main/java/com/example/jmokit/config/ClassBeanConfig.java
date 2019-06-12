package com.example.jmokit.config;

import com.example.jmokit.bean.AnOrdinaryClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassBeanConfig {
    @Bean(value = "anOrdinaryClass")
    public AnOrdinaryClass createOdrBean(){
        return new AnOrdinaryClass();
    }
}
