package com.swkang.springboot.springboothello.service.impl;

import com.swkang.springboot.springboothello.domain.Users;
import com.swkang.springboot.springboothello.mapper.UsersMapper;
import com.swkang.springboot.springboothello.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int add(Users user) {
        usersMapper.insert(user);
        int id = user.getId();
        return id;
    }
}
