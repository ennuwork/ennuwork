package com.eunco.demonstrate.service.impl;

import com.eunco.demonstrate.common.Const;
import com.eunco.demonstrate.common.MessageCode;
import com.eunco.demonstrate.dao.UserInfoMapper;
import com.eunco.demonstrate.entity.UserInfoEntity;
import com.eunco.demonstrate.service.UserService;
import com.eunco.demonstrate.util.DateUtils;
import com.eunco.demonstrate.util.MD5Utils;
import com.eunco.demonstrate.util.UniteMessage;
import com.eunco.demonstrate.vo.UserInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户相关业务逻辑实现类
 *
 * @author ennu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 对象转换
     *
     * @param entity
     * @return
     */
    private UserInfoVO convert(UserInfoEntity entity) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId(entity.getId());
        userInfoVO.setUsername(entity.getUsername());
        userInfoVO.setEmail(entity.getEmail());
        userInfoVO.setPhone(entity.getPhone());
        userInfoVO.setCreateTime(DateUtils.dateToString(entity.getCreateTime()));
        userInfoVO.setUpdateTime(DateUtils.dateToString(entity.getUpdateTime()));
        return userInfoVO;
    }

    /**
     * 用户登录实现
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public UniteMessage userLogin(String username, String password) {
        // 1、对用户名和密码进行非空判断
        if (StringUtils.isBlank(username)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.USERNAME_NOT_EMPTY.getCode(), MessageCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(password)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.PASSWORD_NOT_EMPTY.getCode(), MessageCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        // 2、查看用户名是否存在
        int count = userInfoMapper.selectByUsername(username);
        if (count == 0) {
            // 用户名不存在
            return UniteMessage.createUniteMessageByFail(MessageCode.USERNAME_NOT_EXISTS.getCode(), MessageCode.USERNAME_NOT_EXISTS.getMsg());
        }
        // 3、根据用户名和密码进行查询
        UserInfoEntity entity = userInfoMapper.selectByUsernameAndPassword(username, MD5Utils.getMD5Code(password));
        if (entity == null) {
            return UniteMessage.createUniteMessageByFail(MessageCode.PASSWORD_ERROR.getCode(), MessageCode.PASSWORD_ERROR.getMsg());
        }
        // 4、返回结果
        return UniteMessage.createUniteMessageBySuccess(convert(entity));
    }

    /**
     * 用户注册实现
     *
     * @param entity
     * @return
     */
    @Override
    public UniteMessage userRegister(UserInfoEntity entity) {
        if (entity == null) {
            return UniteMessage.createUniteMessageByFail(MessageCode.PARAMTER_NOT_EMPTY.getCode(), MessageCode.PARAMTER_NOT_EMPTY.getMsg());
        }
        String username = entity.getUsername();
        String password = entity.getPassword();
        String email = entity.getEmail();
        String phone = entity.getPhone();
        String question = entity.getQuestion();
        String answer = entity.getAnswer();

        // 1、判断各项数据是否为空
        if (StringUtils.isBlank(username)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.USERNAME_NOT_EMPTY.getCode(), MessageCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(password)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.PASSWORD_NOT_EMPTY.getCode(), MessageCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(email)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.EMAIL_NOT_EMPTY.getCode(), MessageCode.EMAIL_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(phone)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.PHONE_NOT_EMPTY.getCode(), MessageCode.PHONE_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(question)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.QUESTION_NOT_EMPTY.getCode(), MessageCode.QUESTION_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(answer)) {
            return UniteMessage.createUniteMessageByFail(MessageCode.ANSWER_NOT_EMPTY.getCode(), MessageCode.ANSWER_NOT_EMPTY.getMsg());
        }
        // 2、判断用户名是否已存在
        int count = userInfoMapper.selectByUsername(username);
        if (count > 0) {
            return UniteMessage.createUniteMessageByFail(MessageCode.USERNAME_EMPTY.getCode(), MessageCode.USERNAME_EMPTY.getMsg());
        }
        // 3、判断邮箱是否存在
        int email_count = userInfoMapper.selectByEmail(email);
        if (email_count > 0) {
            // 邮箱已存在
            return UniteMessage.createUniteMessageByFail(MessageCode.EMAIL_EMPTY.getCode(), MessageCode.EMAIL_EMPTY.getMsg());
        }
        // 4、执行注册(对密码进行MD5加密)
        entity.setPassword(MD5Utils.getMD5Code(entity.getPassword()));
        // 设置用户的角色
        entity.setRole(Const.NORMAL_USER);
        int result = userInfoMapper.insert(entity);
        if (result == 0) {
            // 如果result=0则注册失败
            return UniteMessage.createUniteMessageByFail(MessageCode.REGISTER_FAIL.getCode(), MessageCode.REGISTER_FAIL.getMsg());
        }
        // 若果直接用Java中的simpleDateFormate会导致线程不安全问题
        return UniteMessage.createUniteMessageBySuccess();
    }

}























