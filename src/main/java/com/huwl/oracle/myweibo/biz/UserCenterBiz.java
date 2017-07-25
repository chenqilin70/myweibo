package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserCenterBiz extends BaseBiz{
    public List<Weibo> getUserWeiboList(Integer pageNo,Integer pageSize,Integer userid) {
        return weiboMapper.getWeiboByPage(new PageBean(pageSize,pageNo,0),userid);
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
}
