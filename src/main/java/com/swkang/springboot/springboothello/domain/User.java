package com.swkang.springboot.springboothello.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {

    private int age;
    @JsonIgnore//不会序列化
    private String pwd;
    @JsonProperty("account") //添加别名
    @JsonInclude(JsonInclude.Include.NON_NULL) //为空的话不会反回
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8") //格式化日期
    private Date createTime;

    public User(int age, String pwd, String phone, Date createTime) {
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
