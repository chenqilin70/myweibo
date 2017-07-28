package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.UserGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userGroupMapper")
public interface UserGroupMapper  extends BaseMapper<UserGroup>{
    Integer getDefaultGroupId(Integer userId);

    List getGroupsByUser(User loginUser);

    Integer getGroupIdByBoth(User loginedUser, User targetUser);
    boolean updateGroup(Integer relatId,Integer groupid);
}