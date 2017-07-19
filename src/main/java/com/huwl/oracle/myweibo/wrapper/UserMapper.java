package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper  extends BaseMapper<User>{

    int existNickname(String nickname);
}