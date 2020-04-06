package com.eunco.demonstrate.controller;

import com.eunco.demonstrate.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ennu
 */
@RestController
@RequestMapping("/one")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "这是一个测试程序(初版本)";
    }

    /**
     * 用户登录功能
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login.do")
    public UserEntity userLogin(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                                @RequestParam("password")String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        return userEntity;
    }

}
