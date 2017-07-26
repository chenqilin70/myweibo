package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper  extends BaseMapper<User>{

    int existNickname(String nickname);

    User getUserByCondition(User user);

    List<User> searchIncidentalUserByStr(String searchStr);

    List<User> searchUserByStr(PageBean pageBean, String searchStr,User user);

    Integer getSearchUserByStrCount(String searchStr);

}