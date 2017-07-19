package com.huwl.oracle.myweibo.cache_dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BaseCacheDao {
    @Autowired
    protected RedisTemplate redisTemplate;
    protected static final String USER_ID="user.id.";
    protected static final String USER_EXIST_NICKNAME="user.exist.";
    protected Map<Serializable,Serializable> convertObjectToMap(Object o){
        ObjectMapper mapper=new ObjectMapper();
        HashMap map=null;
        try{
            String json=mapper.writeValueAsString(o);
            map=mapper.readValue(json,HashMap.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
