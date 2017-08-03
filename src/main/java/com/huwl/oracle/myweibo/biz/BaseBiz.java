package com.huwl.oracle.myweibo.biz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.pojo.Relationship;
import com.huwl.oracle.myweibo.wrapper.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

public class BaseBiz {
    @Autowired
    protected UserMapper userMapper;
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
    @Autowired
    protected CommentMapper commentMapper;
    @Autowired
    protected ReplayMapper replayMapper;

    protected String correctEncoding(String s){
        try {
            return new String(s.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return s;
        }
    }




}
