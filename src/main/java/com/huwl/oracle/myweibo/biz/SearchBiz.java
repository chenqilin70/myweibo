package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> searchUserByStr(Integer pageNo, String searchStr) {
        PageBean pageBean=new PageBean(50,pageNo,0);
        List<User> list=userMapper.searchUserByStr(pageBean,searchStr);
        return list;
    }
}
