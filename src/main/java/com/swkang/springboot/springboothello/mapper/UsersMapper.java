package com.swkang.springboot.springboothello.mapper;

import com.swkang.springboot.springboothello.domain.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 访问数据库的接口
 */
public interface UsersMapper {

    //如果使用${}取值，会存在sql注入的风险
    @Insert("insert into user(name, phone, create_date, age) values (#{name}, #{phone}, #{create_date}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")  //使用数据库自增长字段
    int insert(Users user);

    /**
     * 查询所有的对象
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(column = "create_date", property = "create_date")
    })
    List<Users> findAll();

    /**
     * 更具id查询对象
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "create_date", property = "create_date")
    })
    Users findById(Integer id);

    /**
     * 更新对象
     * @param users
     */
    @Update("update user set name = #{name} where id = #{id}")
    void update(Users users);

    /**
     * 删除对象
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void delete(Integer id);

}
