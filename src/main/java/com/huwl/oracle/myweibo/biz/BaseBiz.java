package com.huwl.oracle.myweibo.biz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.cache_dao.UserCacheDao;
import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.pojo.Relationship;
import com.huwl.oracle.myweibo.wrapper.*;
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
    @Autowired
    protected UserGroupMapper userGroupMapper;
    @Autowired
    protected RelationshipMapper relationshipMapper;




}
