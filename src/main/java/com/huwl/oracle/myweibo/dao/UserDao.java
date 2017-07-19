package com.huwl.oracle.myweibo.dao;

import com.huwl.oracle.myweibo.pojo.User;

/**
 * Created by aierxuan on 2017/7/17.
 */
public interface UserDao extends BaseDao{
    User addUser(User user);

    Boolean existNickname(String nickname);

    User getUserByNicknameAndPwd(String nickname, String password);
}
