package com.huwl.oracle.myweibo.biz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.cache_dao.UserCacheDao;
import com.huwl.oracle.myweibo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseBiz {
    @Autowired
    protected UserDao userDao;
    @Autowired
    protected UserCacheDao userCacheDao;



}
