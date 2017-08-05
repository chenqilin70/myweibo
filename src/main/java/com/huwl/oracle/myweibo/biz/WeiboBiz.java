package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.Comment;
import com.huwl.oracle.myweibo.pojo.Replay;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeiboBiz extends BaseBiz {

    public void addComment(Comment comment,User user) {
        comment.setCommentContent(comment.getCommentContent()
                .replaceAll("<p>","").replaceAll("</p>","")
                .replaceAll("<br/>","").replaceAll("<br>",""));
        comment.setCommentTime(new Date());
        comment.setUser(user);
        commentMapper.insert(comment);
    }

    public void addReply(Replay replay,User loginedUser) {
        replay.setReplayTimie(new Date());
        replay.setUser(loginedUser);
        replay.setReplayContent(replay.getReplayContent()
                        .replaceAll("<p>","").replaceAll("</p>","")
                        .replaceAll("<br>","").replaceAll("<br/>",""));
        replayMapper.insert(replay);
    }
}
