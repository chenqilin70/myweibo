package com.huwl.oracle.myweibo.daoimpl;

import com.huwl.oracle.myweibo.dao.UserDao;
import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.wrapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by aierxuan on 2017/7/17.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{
    @Autowired
    private UserMapper mapper;
    public UserDaoImpl() {
        super(User.class );
    }


    public User addUser(User user) {
        mapper.insert(user);
        return user;
    }

    public Boolean existNickname(String nickname) {
        return mapper.existNickname(nickname)>0?true:false;
    }
}
