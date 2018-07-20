package com.chenjunlong.springboot.example.ratelimit;

import com.alibaba.fastjson.JSONObject;
import com.github.jratelimit.filter.ControllerRateLimitHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjunlong on 2018/7/19.
 */
public class CustomRateLimitHandler implements ControllerRateLimitHandler {

    @Override
    public Map<String, Integer> limitConfig() {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("action", 1);
        maps.put("action2", 1);
        maps.put("action3", 1);
        return maps;
    }

    @Override
    public JSONObject defaultValue(HttpServletRequest request, HttpServletResponse response, Object handler) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "400");
        jsonObject.put("msg", "接口访问受限2...");
        return jsonObject;
    }
}
