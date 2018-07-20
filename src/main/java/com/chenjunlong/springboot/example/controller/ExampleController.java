package com.chenjunlong.springboot.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.jratelimit.annotation.RateLimit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenjunlong on 2018/7/19.
 */
@RestController
public class ExampleController {

    @RateLimit(defaultMethod = "actionDefaultMethod")
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public JSONObject action() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "1");
        jsonObject.put("msg", "操作成功");
        return jsonObject;
    }

    public JSONObject actionDefaultMethod() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "400");
        jsonObject.put("msg", "接口访问受限");
        return jsonObject;
    }

    @RateLimit(defaultMethod = "actionDefaultMethod2")
    @RequestMapping(value = "/action2", method = {RequestMethod.POST, RequestMethod.GET})
    public JSONObject action2(@RequestParam String name) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "1");
        jsonObject.put("msg", "操作成功");
        jsonObject.put("name", name);
        return jsonObject;
    }

    public JSONObject actionDefaultMethod2(String name) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "400");
        jsonObject.put("msg", "接口访问受限");
        jsonObject.put("name", name);
        return jsonObject;
    }

    @RateLimit(defaultMethod = "actionDefaultMethod3")
    @RequestMapping(value = "/action3", method = {RequestMethod.POST, RequestMethod.GET})
    public JSONObject action3(@RequestParam String name, @RequestParam Integer age) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "1");
        jsonObject.put("msg", "操作成功");
        jsonObject.put("name", name);
        jsonObject.put("age", age);
        return jsonObject;
    }

    public JSONObject actionDefaultMethod3(String name, Integer age) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "400");
        jsonObject.put("msg", "接口访问受限");
        jsonObject.put("name", name);
        jsonObject.put("age", age);
        return jsonObject;
    }
}
