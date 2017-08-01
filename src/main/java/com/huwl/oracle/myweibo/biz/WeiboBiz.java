package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.Comment;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeiboBiz extends BaseBiz {

    public void addComment(Comment comment,User user) {
        comment.setCommentTime(new Date());
        comment.setUser(user);
        commentMapper.insert(comment);
    }
}
