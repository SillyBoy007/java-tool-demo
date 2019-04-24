package com.example.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableMethodCache(basePackages = "com.example.jetcache")
@EnableCreateCacheAnnotation
@SpringBootApplication
public class JetcaheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetcaheDemoApplication.class, args);
    }

}
