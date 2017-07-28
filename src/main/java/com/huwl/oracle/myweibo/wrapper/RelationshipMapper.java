package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.Relationship;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipMapper extends BaseMapper<Relationship>{



    Integer getRelatId(Integer userid, User loginedUser);

}