package com.eunco.demonstrate.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author ennu
 */
@Data
public class UserInfoEntity {

    private Integer id;

    private String username;

    private String password;

    private String userpic;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;

    private String ip;

}