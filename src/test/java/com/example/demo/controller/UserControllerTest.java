package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.TestUser;
import com.example.demo.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.Optional;
/*
 * @Author liuxin
 * @Description //TODO
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;
    @Autowired
    private TestUser testUser;


    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        UserInfo user = new UserInfo();
        session.setAttribute("user", user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }


    @Test
    public void testDome() {
        System.out.println(testUser);


    }

    @Test
    @Transactional
    public void addLearn() throws Exception {
        UserInfo user = new UserInfo();

        user.setUsername("刘信").setEmail("www.799296010@qq.com").setIdCard("12345678")
                .setMobile("17673817175").setPassword("12432421")
                .setId(432432L).setCreateTime(new Date()).setUpdateTime(new Date());
        UserInfo user1 = new UserInfo();
        Optional<UserInfo> opt = Optional.of(user1);
        opt.get();
        log.info(opt.get().toString());
        String jsonString = JSON.toJSONString(user);
        log.info(jsonString);
        mvc.perform(MockMvcRequestBuilders.post("/user/insert")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString.getBytes()) //传json参数
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


}
