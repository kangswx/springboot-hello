package com.swkang.springboot.springboothello.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:application.properties"})
//@ConfigurationProperties
@ConfigurationProperties(prefix = "test")
public class ServerSettings {

    //名称
    //@Value("${name}")  //使用前缀的话就不用通过Value的方法注入参数，不使用前缀的话需要通过Value的方式注入配置文件中的参数
    private String name;

    //域名地址
    //@Value("${domain}")
    private String domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
