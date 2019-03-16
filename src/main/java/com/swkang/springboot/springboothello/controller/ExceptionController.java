package com.swkang.springboot.springboothello.controller;

import com.swkang.springboot.springboothello.domain.MyException;
import com.swkang.springboot.springboothello.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 异常测试
 */
@RestController
public class ExceptionController {

    @RequestMapping("/api/v1/test_exept")
    public Object index(){
        int i = 1 / 0;
        return new User(11, "123212", "18659595959", new Date());
    }

    @RequestMapping("/api/v1/my_except")
    public Object myExcept(){
        throw new MyException("500", "my except异常");
    }
}
