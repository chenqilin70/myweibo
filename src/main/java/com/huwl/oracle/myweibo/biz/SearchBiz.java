package com.huwl.oracle.myweibo.biz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.huwl.oracle.myweibo.pojo.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("searchBiz")
public class SearchBiz extends BaseBiz{
    public List<Weibo> searchWeiboByStr(Integer pageNo,String searchStr) {
        PageBean pageBean=new PageBean(20,pageNo,0);
        List<Weibo> list=weiboMapper.searchWeiboByStr(pageBean,searchStr);
        return list;
    }

    public List<User> searchIncidentalUserByStr(String searchStr) {
        return userMapper.searchIncidentalUserByStr(searchStr);
    }

    public List<User> searchUserByStr(Integer pageNo, String searchStr,User user) {
        PageBean pageBean=new PageBean(50,pageNo,0);
        List<User> list=userMapper.searchUserByStr(pageBean,searchStr,user);
        return list;
    }

    public String getSearchUserPageBean(String searchStr,Integer pageNo,User user) {
        String jsonBean="";
        try {
            jsonBean=objectMapper.writeValueAsString(
                    new PageBean(50,pageNo,userMapper.getSearchUserByStrCount(searchStr,user))
            );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonBean.replace("\"","\'");
    }

    public String getSearchWeiboPageBean(String searchStr, Integer pageNo) {
        String jsonBean="";
        try {
            jsonBean=objectMapper.writeValueAsString(
                    new PageBean(50,pageNo,weiboMapper.getSearchWeiboByStrCount(searchStr))
            );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonBean.replace("\"","\'");
    }

    public boolean addCare(Integer userid, User loginedUser) {
        UserGroup userGroup=new UserGroup();
        userGroup.setGroupId(redisCacheMapper.getDefaultGroupId(loginedUser.getUserId()));
        loginedUser.setDefaultGroup(userGroup);
        Relationship relationship=new Relationship();
        User star=new User();
        star.setUserId(userid);
        relationship.setStar(star);
        relationship.setUserGroup(userGroup);
        relationship.setCareTime(new Date());
        int count=relationshipMapper.insert(relationship);
        return count>0?true:false;
    }

    public List getGroupsByUser(User loginUser) {
        return redisCacheMapper.getGroupsByUser(loginUser);
    }

    public boolean grouping(Integer groupid, Integer userid, User loginedUser) {
        Integer relatId=relationshipMapper.getRelatId(userid,loginedUser);
        return relationshipMapper.updateGroup(relatId,groupid);
    }

    public UserGroup addGroup(String groupName, User loginedUser) {
//        UserGroup userGroup=new UserGroup();
//        userGroup.setUser(loginedUser);
//        userGroup.setGroupName(groupName);
//        userGroup
//        return
        return null;
    }
}
