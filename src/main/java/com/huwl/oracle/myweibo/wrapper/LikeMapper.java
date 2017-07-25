package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.Like;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("likeMapper")
public interface LikeMapper  extends BaseMapper<Like>{
    boolean addLike(Like like);
}