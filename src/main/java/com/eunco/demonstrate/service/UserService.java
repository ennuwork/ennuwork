package com.eunco.demonstrate.service;

import com.eunco.demonstrate.entity.UserInfoEntity;
import com.eunco.demonstrate.util.UniteMessage;

/**
 * 用户接口
 * @author ennu
 */
public interface UserService {

    /**
     * 用户登录接口
     *
     * @param username
     * @param password
     * @return
     */
    UniteMessage userLogin(String username, String password);

    /**
     * 用户注册接口
     *
     * @param entity
     * @return
     */
    UniteMessage userRegister(UserInfoEntity entity);

}
