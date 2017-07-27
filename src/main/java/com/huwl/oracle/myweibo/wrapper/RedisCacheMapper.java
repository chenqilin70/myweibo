package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RedisCacheMapper {
   Integer getDefaultGroupId(Integer userId);

    List getGroupsByUser(User loginUser);
}
