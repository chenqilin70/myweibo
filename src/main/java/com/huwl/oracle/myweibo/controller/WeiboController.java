package com.huwl.oracle.myweibo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.biz.WeiboBiz;
import com.huwl.oracle.myweibo.pojo.Comment;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller("weiboController")
@RequestMapping("/inner")
public class WeiboController extends BaseController {
    @Autowired
    private WeiboBiz weiboBiz;
    @Autowired
    private ObjectMapper objectMapper;
    @RequestMapping("/addComment")
    @ResponseBody
    public String addComment(Comment comment, HttpSession session){
        String result="";
        comment.setCommentContent(comment.getCommentContent()
                .replaceAll("<p>","").replaceAll("</p>",""));
        weiboBiz.addComment(comment,getLoginedUser(session));
        try {
            result=comment.getCommentContent()==null?"null":objectMapper.writeValueAsString(comment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}




















