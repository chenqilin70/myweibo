package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WeiboMapper  extends BaseMapper<Weibo>{

    List<Weibo> getWeiboByPage(PageBean pageBean, Integer userid);
}