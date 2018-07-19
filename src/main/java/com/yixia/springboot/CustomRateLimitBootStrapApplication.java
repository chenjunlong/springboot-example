package com.yixia.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by chenjunlong on 2018/7/19.
 * <p>
 * 通过加载custom-ratelimit.xml中配置的CustomRateLimitHandler进行限流配置的读取
 */
@SpringBootApplication(scanBasePackages = "com.yixia.springboot.example")
@ImportResource(locations = {"classpath:/META-INF/custom-ratelimit.xml"})
public class CustomRateLimitBootStrapApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CustomRateLimitBootStrapApplication.class, args);
    }
}