package com.swkang.springboot.springboothello.service.impl;

import com.swkang.springboot.springboothello.domain.Users;
import com.swkang.springboot.springboothello.mapper.UsersMapper;
import com.swkang.springboot.springboothello.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int add(Users user) {
        usersMapper.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addAccount() {
        Users users = new Users();
        users.setAge(88);
        users.setCreate_date(new Date());
        users.setName("测试事务啦");
        users.setPhone("18645757489");
        usersMapper.insert(users);
        int i = 9 / 0;
        return 0;
    }
}
