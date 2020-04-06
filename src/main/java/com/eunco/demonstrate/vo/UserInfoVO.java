package com.eunco.demonstrate.vo;

import lombok.Data;

/**
 * Demo class
 *
 * @author ennu
 * @date 2020-4-6
 **/
@Data
public class UserInfoVO {

    private Integer id;

    private String username;

    private String userpic;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private String createTime;

    private String updateTime;

    private String ip;

}
