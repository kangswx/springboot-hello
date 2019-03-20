package com.swkang.springboot.springboothello.mapper;

import com.swkang.springboot.springboothello.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * 访问数据库的接口
 */
public interface UsersMapper {

    //如果使用${}取值，会存在sql注入的风险
    @Insert("insert into user(name, phone, create_date, age) values (#{name}, #{phone}, #{create_date}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")  //使用数据库自增长字段
    int insert(Users user);

}
