package com.eunco.demonstrate.dao;

import com.eunco.demonstrate.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2020-04-05
 * @author ennu
 */
public interface UserInfoMapper {

    /**
     * 根据ID删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(UserInfoEntity record);

    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    UserInfoEntity selectByPrimaryKey(Integer id);

    /**
     * 查询所有数据
     * @return
     */
    List<UserInfoEntity> selectAll();

    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(UserInfoEntity record);

    /**
     * 校验用户名是否重复
     * @param username
     * @return
     */
    int selectByUsername(@Param("username")String username);

    /**
     * 判断邮箱是否存在
     * @param email
     * @return
     */
    int selectByEmail(@Param("email")String email);

    /**
     * 根据用户名和密码进行查询
     * @param username
     * @param password
     * @return
     */
    UserInfoEntity selectByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

}