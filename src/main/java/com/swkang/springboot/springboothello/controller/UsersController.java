package com.swkang.springboot.springboothello.controller;

import com.swkang.springboot.springboothello.domain.Users;
import com.swkang.springboot.springboothello.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("add")
    public Object add(){
        Users users = new Users();
        users.setAge(11);
        users.setName("swkang");
        users.setPhone("18454545454");
        users.setCreate_date(new Date());
        int id = usersService.add(users);
        return id;
    }

}
