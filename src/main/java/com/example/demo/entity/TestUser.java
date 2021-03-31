package com.example.demo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
@Component //把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
@ConfigurationProperties(prefix = "TestUser") //可以获取application.properties 或 application.yml 文件中的参数，通过Component对于对象进行实例化
public class TestUser {
    private  String name;
    private   String age;



}
