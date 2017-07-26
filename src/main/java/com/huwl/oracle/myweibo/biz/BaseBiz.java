package com.huwl.oracle.myweibo.biz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.cache_dao.UserCacheDao;
import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.wrapper.LikeMapper;
import com.huwl.oracle.myweibo.wrapper.UserMapper;
import com.huwl.oracle.myweibo.wrapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseBiz {
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    protected UserCacheDao userCacheDao;
    @Autowired
    protected WeiboMapper  weiboMapper;
    @Autowired
    protected LikeMapper likeMapper;
    @Autowired
    protected ObjectMapper objectMapper;




}
