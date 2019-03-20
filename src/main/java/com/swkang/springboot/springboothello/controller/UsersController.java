package com.swkang.springboot.springboothello.controller;

import com.swkang.springboot.springboothello.domain.Users;
import com.swkang.springboot.springboothello.mapper.UsersMapper;
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
    @Autowired
    private UsersMapper usersMapper;

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

    @GetMapping("findAll")
    public Object findAll(){
        return usersMapper.findAll();
    }

    @GetMapping("find")
    public Object findById(Integer id){
        return usersMapper.findById(id);
    }

    @GetMapping("update")
    public Object update(Users users){
        usersMapper.update(users);
        return users;
    }

    @GetMapping("delete")
    public Object delete(Integer id){
        usersMapper.delete(id);
        return "delete success";
    }

}
