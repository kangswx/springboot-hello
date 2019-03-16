package com.swkang.springboot.springboothello.controller;

import com.swkang.springboot.springboothello.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SimpleController {

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/testMap")
    public Map<String, String> testMap(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "swkang");
        return map;
    }

    /**
     * json测试的方法
     * @return
     */
    @RequestMapping("/testjson")
    public Object testJson(){
        User user = new User(18, "123456", "18629676774", new Date());
        return user;
    }

    /**
     * MockMvc测试
     * @return
     */
    @RequestMapping("/test/home")
    public String home(){
        return "swkangclass";
    }
}
