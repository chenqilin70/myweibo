package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("likeMapper")
public interface LikeMapper  extends BaseMapper<Like>{
    boolean addLike(Like like);


    Integer getLikeId(User user, Integer weiboid);
}