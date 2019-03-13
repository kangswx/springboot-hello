package com.swkang.springboot.springboothello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
