package com.huwl.oracle.myweibo.biz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("userCenterBiz")
public class UserCenterBiz extends BaseBiz{
    public List<Weibo> getUserWeiboList(Integer pageNo
            ,Integer pageSize,User user) {
        List<Weibo> list=
            weiboMapper.getWeiboByPage(new PageBean(pageSize,pageNo,0),user.getUserId());
        return list;
    }

    public String like(User user, Integer weiboid) {
        //查看是否已经点过赞
        Integer likeId=likeMapper.getLikeId(user,weiboid);
        if(likeId==null){
            Like like=new Like();
            like.setLikeTime(new Date());
            like.setUser(user);
            Weibo weibo=new Weibo();
            weibo.setWeiboId(weiboid);
            like.setWeibo(weibo);
            return likeMapper.addLike(like)?"addLikeSuccess":"addLikeError";
        }else{
            return likeMapper.delete(likeId)?"deleteLikeSuccess":"deleteLikeError";
        }

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
