package com.huwl.oracle.myweibo.biz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserCenterBiz extends BaseBiz{
    public List<Weibo> getUserWeiboList(Integer pageNo
            ,Integer pageSize,User user) {
        List<Weibo> list=
            weiboMapper.getWeiboByPage(new PageBean(pageSize,pageNo,0),user.getUserId());
        return list;
    }

    public boolean like(User user, Integer weiboid) {
        Like like=new Like();
        like.setLikeTime(new Date());
        like.setUser(user);
        Weibo weibo=new Weibo();
        weibo.setWeiboId(weiboid);
        like.setWeibo(weibo);
        return likeMapper.addLike(like);
    }

    public String getUserWeiboPageBean(Integer pageNo,User user) {
        PageBean pageBean=new PageBean(15,pageNo,weiboMapper.getUsersWeiboCount(user));
        String result="";
        try {
            result=objectMapper.writeValueAsString(pageBean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result.replace("\"","\'");
    }
}
