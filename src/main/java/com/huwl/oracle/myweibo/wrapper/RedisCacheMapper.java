package com.huwl.oracle.myweibo.wrapper;

import org.springframework.stereotype.Repository;

@Repository
public interface RedisCacheMapper {
   Integer getDefaultGroupId(Integer userId);
}
