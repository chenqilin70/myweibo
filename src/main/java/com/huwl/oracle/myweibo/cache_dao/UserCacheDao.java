package com.huwl.oracle.myweibo.cache_dao;

import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserCacheDao extends BaseCacheDao{
    public void addUser(User user) {
        String userid="user.id."+user.getUserId().toString();
        Map map=convertObjectToMap(user);
        redisTemplate.opsForHash().putAll(userid,map);
    }

    public Boolean existNickname(String nickname) {
        return (Boolean) redisTemplate.opsForValue().get(USER_EXIST_NICKNAME+nickname)==null?false:true;
    }
}
