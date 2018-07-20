package com.chenjunlong.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by chenjunlong on 2018/7/19.
 * <p>
 * 读取jratelimit.properties获取限流配置
 */
@SpringBootApplication(scanBasePackages = "com.chenjunlong.springboot.example")
@ImportResource(locations = {"classpath:/META-INF/prop-ratelimit.xml"})
public class PropRateLimitBootStrapApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PropRateLimitBootStrapApplication.class, args);
    }
}