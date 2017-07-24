package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCenterBiz extends BaseBiz{
    public List<Weibo> getUserWeiboList(Integer pageNo,Integer pageSize,Integer userid) {
        return weiboMapper.getWeiboByPage(new PageBean(pageSize,pageNo,0),userid);
    }
}
