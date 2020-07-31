package com.tacocloud.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
//@WebMvcTest注解。这是Spring Boot所提供的一个特殊测试注解，它会让这个测试在Spring MVC应用的上下文中执行
@WebMvcTest(HomeController.class) //Web test for HomeController
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;  //Injects MockMvc

    /**
     * 如果在MockMvc对象发送请求之后，这些期望有不满足的话，那么这个测试会失败。
     * 但是，我们的控制器和模板引擎在编写时都满足了这些预期，所以测试应该能够通过，
     * 并且带有成功的图标——至少能够看到一些绿色的背景，表明测试通过了。
     * @throws Exception
     */
    @Test
    public void testHomePage() throws Exception {
        /**
         * •响应应该具备HTTP 200 (OK)状态；
         * •视图的逻辑名称应该是home；
         * •渲染后的视图应该包含文本“Welcome to...”。
         */
        mockMvc.perform(get("/")) //发起对“/”的get
                .andExpect(status().isOk()) //Expects HTTP 200
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Welcome to...")));
    }
}