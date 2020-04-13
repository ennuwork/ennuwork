package com.eunco.demonstrate.controller;

import com.eunco.demonstrate.common.Const;
import com.eunco.demonstrate.entity.UserInfoEntity;
import com.eunco.demonstrate.service.UserService;
import com.eunco.demonstrate.util.UniteMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户功能模块
 * @author ennu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @GetMapping(value = "/login.do")
    public UniteMessage userLogin(String username, String password, HttpSession session) {
        UniteMessage uniteMessage = userService.userLogin(username, password);
        // 判断是否登录成功, 成功则保存session
        if (uniteMessage.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, uniteMessage.getData());
        }
        return uniteMessage;
    }

    /**
     * 用户注册
     * @param entity
     * @return
     */
    @PostMapping(value = "/register.do")
    public UniteMessage userRegister(UserInfoEntity entity) {
        return userService.userRegister(entity);
    }

}





































