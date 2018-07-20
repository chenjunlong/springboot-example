package com.chenjunlong.springboot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.jratelimit.annotation.RateLimitComponentScan;
import com.github.jratelimit.filter.ControllerRateLimitHandler;
import com.github.jratelimit.filter.ControllerRateLimitInterceptor;
import com.chenjunlong.springboot.example.ratelimit.CustomRateLimitHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by chenjunlong on 2018/7/19.
 * <p>
 * 通过注解配置扫描包进行限流配置
 */
@RateLimitComponentScan(basePackages = {"com.chenjunlong.springboot.example"})
@SpringBootApplication(scanBasePackages = "com.chenjunlong.springboot.example")
public class AnnotationRateLimitBootStrapApplication implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ControllerRateLimitHandler rateLimitHandler = new CustomRateLimitHandler();
        registry.addInterceptor(new ControllerRateLimitInterceptor(rateLimitHandler)).addPathPatterns("/**");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AnnotationRateLimitBootStrapApplication.class, args);
    }
}